package com.musala.testdrones.danissalakheev.dto;

import com.musala.testdrones.danissalakheev.enums.DroneModel;
import lombok.Data;

@Data
public class DroneBatteryDto {

    private Long id;
    private DroneModel model;
    private String serialNumber;
    private int batteryCapacity;

}
