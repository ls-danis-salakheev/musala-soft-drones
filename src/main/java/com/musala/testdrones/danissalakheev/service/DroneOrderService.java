package com.musala.testdrones.danissalakheev.service;

import com.musala.testdrones.danissalakheev.dto.MedicationDto;
import com.musala.testdrones.danissalakheev.entity.Drone;

public interface DroneOrderService {

    void loadMedicationToDrone(MedicationDto medicationDto, Drone drone);

}
