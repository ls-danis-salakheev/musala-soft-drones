package com.musala.testdrones.danissalakheev.service.impl;

import com.musala.testdrones.danissalakheev.dto.*;
import com.musala.testdrones.danissalakheev.entity.Medication;
import com.musala.testdrones.danissalakheev.exception.DroneProcessException;
import com.musala.testdrones.danissalakheev.exception.EntityProcessException;
import com.musala.testdrones.danissalakheev.mapper.DroneMapper;
import com.musala.testdrones.danissalakheev.mapper.MedicationMapper;
import com.musala.testdrones.danissalakheev.repository.DroneRepository;
import com.musala.testdrones.danissalakheev.service.DroneService;
import com.musala.testdrones.danissalakheev.service.FileService;
import com.musala.testdrones.danissalakheev.service.MedicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static com.musala.testdrones.danissalakheev.enums.DroneState.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class DroneServiceImpl implements DroneService {

    @Value("${app.drones.batteryCapacity.available}")
    private int batteryCapacity;

    private final FileService fileService;
    private final DroneRepository droneRepository;
    private final MedicationService medicationService;

    @Override
    public Long register(DroneInputDto drone) {
        return droneRepository.save(DroneMapper.INSTANCE.map(drone))
                .getId();
    }

    @Override
    @Transactional
    public void loadWithMedications(String serialNumber,
                                    MedicationDto medicationDto,
                                    MultipartFile image) {
        droneRepository.findFirstBySerialNumber(serialNumber)
                .ifPresentOrElse(drone -> {
                    if (drone.getBatteryCapacity() < batteryCapacity) {
                        log.error("The drone with {} has the low battery capacity. Loading isn't possible", serialNumber);
                        throw new DroneProcessException("The drone has the low battery capacity");
                    } else if (!LOADABLE_STATES.contains(drone.getState())) {
                        log.error("The drone with serial number = {} is at the {} stage. It's not ready to be loaded", serialNumber, drone.getState());
                        throw new DroneProcessException("The drone isn't ready to load");
                    } else if (medicationDto.getWeight() >= drone.getWeightLimit()
                               || (drone.getWeightLimit() + medicationDto.getWeight()) >= drone.getWeightLimit()) {
                        log.error("Cannot add the medication because the drone with serial number = {} can take over only {} g additionally",
                                serialNumber, drone.getWeightLimit() - medicationDto.getWeight());
                        throw new DroneProcessException("The drone's mass overloaded");
                    } else {
                        Medication medication = MedicationMapper.INSTANCE.map(medicationDto, fileService.readFile(image));
                        if (drone.getState() == IDLE) {
                            drone.setState(LOADING);
                        }
                        drone.addMedication(medication);
                    }
                }, () -> {
                    log.error("Cannot find the Drone entity with serial = {}", serialNumber);
                    throw new EntityProcessException("Entity with serialNumber %s not found".formatted(serialNumber));
                });
    }

    @Override
    public DroneBatteryDto getAvailableByBattery(String serialNumber) {
        return droneRepository.findFirstBySerialNumber(serialNumber)
                .map(DroneMapper.INSTANCE::mapToBatteryDto)
                .orElseThrow(() -> new EntityProcessException("Entity with serialNumber %s not found".formatted(serialNumber)));
    }

    @Override
    public List<DroneInputDto> getAllAvailableForLoad() {
        return droneRepository.findAllAvailableForLoad(batteryCapacity, IDLE)
                .stream().map(DroneMapper.INSTANCE::mapToDto)
                .toList();
    }

    @Override
    public List<DroneOutDto> getAll(int page, int size) {
        return droneRepository.findAll(PageRequest.of(page, size)).stream()
                .map(DroneMapper.INSTANCE::mapToOutputDto)
                .toList();
    }

    @Override
    public LoadedDroneDto findLoaded(String serialNumber) {
        return droneRepository.findFirstBySerialNumber(serialNumber)
                .map(drone -> DroneMapper.INSTANCE.mapToLoadedDto(drone, medicationService.getAllByDroneSN(serialNumber)))
                .orElseThrow(() -> new EntityProcessException("Drone with serial number %s not found".formatted(serialNumber)));
    }
}
