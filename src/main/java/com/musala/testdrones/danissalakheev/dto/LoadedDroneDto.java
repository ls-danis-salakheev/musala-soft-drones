package com.musala.testdrones.danissalakheev.dto;

import com.musala.testdrones.danissalakheev.enums.DroneModel;
import com.musala.testdrones.danissalakheev.enums.DroneState;
import lombok.Data;

import java.util.List;

@Data
public class LoadedDroneDto {

    private Long id;
    private String serialNumber;
    private DroneModel model;
    private DroneState state;
    private List<MedicationOutDto> medications;

}
