package com.musala.testdrones.danissalakheev.service;

import com.musala.testdrones.danissalakheev.dto.MedicationOutDto;

import java.util.List;

public interface MedicationService {

    List<MedicationOutDto> getAllByDroneSN(String droneSerialNumber);

}
