package com.musala.testdrones.danissalakheev.service.impl;

import com.musala.testdrones.danissalakheev.dto.MedicationOutDto;
import com.musala.testdrones.danissalakheev.mapper.MedicationMapper;
import com.musala.testdrones.danissalakheev.repository.MedicationRepository;
import com.musala.testdrones.danissalakheev.service.MedicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicationServiceImpl implements MedicationService {

    private final MedicationRepository medicationRepository;

    @Override
    public List<MedicationOutDto> getAllByDroneSN(String droneSerialNumber) {
        return medicationRepository
                .findAllByDrone_SerialNumber(droneSerialNumber).stream()
                .map(MedicationMapper.INSTANCE::map)
                .toList();
    }
}
