package com.musala.testdrones.danissalakheev.controller;

import com.musala.testdrones.danissalakheev.dto.*;
import com.musala.testdrones.danissalakheev.service.DroneService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

import static com.musala.testdrones.danissalakheev.util.Constants.*;
import static org.springframework.http.HttpStatus.CREATED;

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
    public List<DroneOutDto> fetchAllDrones(@RequestParam(required = false, defaultValue = DEFAULT_PAGE) int page,
                                            @RequestParam(required = false, defaultValue = DEFAULT_SIZE) int size,
                                            @RequestParam(required = false, defaultValue = DEFAULT_SORTING_DIRECTION) Sort.Direction direction,
                                            @RequestParam(required = false, defaultValue = DRONE_DEFAULT_SORTING_PROPS) String[] properties) {
        return droneService.getAll(PageRequest.of(page, size, direction, properties));
    }

    @GetMapping("/available")
    public List<DroneInputDto> getAvailableDronesForLoad(@RequestParam(required = false, defaultValue = DEFAULT_PAGE) int page,
                                                         @RequestParam(required = false, defaultValue = DEFAULT_SIZE) int size,
                                                         @RequestParam(required = false, defaultValue = DEFAULT_SORTING_DIRECTION) Sort.Direction direction,
                                                         @RequestParam(required = false, defaultValue = DRONE_DEFAULT_SORTING_PROPS) String[] properties) {
        return droneService.getAllAvailableForLoad(PageRequest.of(page, size, direction, properties));
    }

    @PutMapping("/{serialNumber}")
    public ResponseEntity<Object> loadDroneWithMedication(@PathVariable String serialNumber,
                                                          @RequestPart MultipartFile image,
                                                          @RequestPart @Valid MedicationDto medicationDto) {
        droneService.loadWithMedications(serialNumber, medicationDto, image);
        return new ResponseEntity<>(CREATED);
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
