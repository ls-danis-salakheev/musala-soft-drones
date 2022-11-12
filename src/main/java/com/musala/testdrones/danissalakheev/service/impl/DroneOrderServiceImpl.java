package com.musala.testdrones.danissalakheev.service.impl;

import com.musala.testdrones.danissalakheev.dto.MedicationDto;
import com.musala.testdrones.danissalakheev.entity.Drone;
import com.musala.testdrones.danissalakheev.entity.DroneOrder;
import com.musala.testdrones.danissalakheev.enums.DroneOrderState;
import com.musala.testdrones.danissalakheev.enums.DroneState;
import com.musala.testdrones.danissalakheev.exception.DroneProcessException;
import com.musala.testdrones.danissalakheev.mapper.MedicationMapper;
import com.musala.testdrones.danissalakheev.repository.DroneOrderRepository;
import com.musala.testdrones.danissalakheev.repository.MedicationRepository;
import com.musala.testdrones.danissalakheev.service.DroneOrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.musala.testdrones.danissalakheev.enums.DroneState.IDLE;

@Slf4j
@Service
@RequiredArgsConstructor
public class DroneOrderServiceImpl implements DroneOrderService {

    private final MedicationRepository medicationRepository;
    private final DroneOrderRepository droneOrderRepository;

    @Override
    @Transactional
    public void loadMedicationToDrone(MedicationDto medicationDto, Drone drone) {
        droneOrderRepository.findOrderByStateAndDrone(DroneOrderState.CREATED, drone)
                .ifPresentOrElse(order -> {
                    final int currentWeight = medicationRepository.calculateTotalWeightByOrder(order);
                    final int medicationWeight = medicationDto.getWeight();
                    final int droneWeightLimit = drone.getWeightLimit();
                    if (medicationWeight > currentWeight) {
                        log.error("Cannot add the medication because the current order of drone with serial " +
                                  "number = {} can take over only {} g additionally",
                                drone.getSerialNumber(), droneWeightLimit - currentWeight);
                        throw new DroneProcessException("The drone's mass overloaded");
                    } else if ((currentWeight + medicationWeight) > droneWeightLimit) {
                        log.error("Cannot add the medication because the drone with serial number = {} will be " +
                                  "overloaded with the medication, current order's weight is {}",
                                drone.getSerialNumber(), currentWeight);
                        throw new DroneProcessException("The drone's mass overloaded");
                    } else {
                        order.addMedication(MedicationMapper.INSTANCE.map(medicationDto));
                        setLoadingState(drone);
                    }
                }, () -> {
                    DroneOrder newOrder = new DroneOrder(drone, MedicationMapper.INSTANCE.map(medicationDto));
                    droneOrderRepository.save(newOrder);
                    setLoadingState(drone);
                });
    }

    private void setLoadingState(Drone drone) {
        if (drone.getState() == IDLE) {
            drone.setState(DroneState.LOADING);
        }
    }
}
