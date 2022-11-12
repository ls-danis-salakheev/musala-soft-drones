package com.musala.testdrones.danissalakheev.service;

import com.musala.testdrones.danissalakheev.dto.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DroneService {

    Long register(DroneInputDto drone);

    void loadWithMedications(String serialNumber, MedicationDto medications, MultipartFile image);

    DroneBatteryDto getAvailableByBattery(String serialNumber);

    List<DroneInputDto> getAllAvailableForLoad(PageRequest pageRequest);

    List<DroneOutDto> getAll(PageRequest pageRequest);

    LoadedDroneDto findLoaded(String serialNumber);

}
