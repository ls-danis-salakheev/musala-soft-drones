package com.musala.testdrones.danissalakheev.service;

import com.musala.testdrones.danissalakheev.dto.MedicationDto;

import java.util.List;

public interface MedicationService {

    List<MedicationDto> getAllByDroneSN(String droneSerialNumber);

}
