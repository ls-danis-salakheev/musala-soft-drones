package com.musala.testdrones.danissalakheev.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.musala.testdrones.danissalakheev.enums.DroneModel;
import com.musala.testdrones.danissalakheev.enums.DroneState;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * serial number (100 characters max);
 * model (Lightweight, Middleweight, Cruiserweight, Heavyweight);
 * weight limit (500gr max);
 * battery capacity (percentage);
 * state (IDLE, LOADING, LOADED, DELIVERING, DELIVERED, RETURNING).
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class DroneInputDto {

    @EqualsAndHashCode.Include
    @NotNull(message = "serial number must be not null")
    @NotBlank(message = "check serial number, probably it's blank")
    @Size(max = 100, message = "length of serialNumber range from 0 to 100")
    private String serialNumber;

    @EqualsAndHashCode.Include
    @NotNull(message = "model must be not null")
    @com.musala.testdrones.danissalakheev.validator.annotation.DroneModel
    private DroneModel model;

    @Max(value = 500, message = "weightLimit must be up to 500 g")
    private Integer weightLimit;

    @Max(value = 100, message = "batteryCapacity must be in the range from 0 to 100")
    private Integer batteryCapacity;

    private DroneState state;

}
