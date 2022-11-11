package com.musala.testdrones.danissalakheev.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MedicationOutDto extends MedicationDto {

    @EqualsAndHashCode.Include
    private Long id;

}
