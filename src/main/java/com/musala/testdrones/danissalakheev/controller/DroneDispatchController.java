package com.musala.testdrones.danissalakheev.controller;

import com.musala.testdrones.danissalakheev.dto.*;
import com.musala.testdrones.danissalakheev.service.DroneService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/drones")
public class DroneDispatchController {

    private final DroneService droneService;

    @PostMapping
    public Long registerDrone(@RequestBody @Valid DroneInputDto drone) {
        return droneService.register(drone);
    }

    @GetMapping
    public List<DroneOutDto> fetchAllDrones(@RequestParam(value = "size", defaultValue = "${app.pagination.defaultPage}") int page,
                                            @RequestParam(value = "page", defaultValue = "${app.pagination.defaultSize}") int size) {
        return droneService.getAll(page, size);
    }

    @GetMapping("/available")
    public List<DroneInputDto> getAvailableDronesForLoad(@RequestParam(value = "page", defaultValue = "${app.pagination.defaultSize}") int page,
                                                         @RequestParam(value = "size", defaultValue = "${app.pagination.defaultPage}") int size) {
        return droneService.getAllAvailableForLoad();
    }

    @PutMapping("/{serialNumber}")
    public LoadedDroneDto loadDroneWithMedication(@PathVariable String serialNumber,
                                                  @RequestParam MultipartFile image,
                                                  @RequestBody MedicationDto medicationDto) {
        return droneService.loadWithMedications(serialNumber, Collections.emptyList());
    }

    @GetMapping("/{serialNumber}/loaded")
    public LoadedDroneDto checkDroneByLoad(@PathVariable String serialNumber) {
        return droneService.findLoaded(serialNumber);
    }

    @GetMapping("/{serialNumber}/battery")
    public DroneBatteryDto checkDroneByBattery(@PathVariable String serialNumber) {
        return droneService.getAvailableByBattery(serialNumber);
    }
}
