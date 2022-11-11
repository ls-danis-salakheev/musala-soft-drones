package com.musala.testdrones.danissalakheev.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class DroneOutDto extends DroneInputDto {

    private Long id;

}
