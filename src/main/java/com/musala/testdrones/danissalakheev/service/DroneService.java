package com.musala.testdrones.danissalakheev.service;

import com.musala.testdrones.danissalakheev.dto.*;

import java.util.List;

public interface DroneService {

    Long register(DroneInputDto drone);

    LoadedDroneDto loadWithMedications(String serialNumber, List<MedicationDto> medications);

    DroneBatteryDto getAvailableByBattery(String serialNumber);

    List<DroneInputDto> getAllAvailableForLoad();

    List<DroneOutDto> getAll(int page, int size);

    LoadedDroneDto findLoaded(String serialNumber);

}
