package com.musala.testdrones.danissalakheev.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

/**
 * Each Medication has:
 *
 * name (allowed only letters, numbers, ‘-‘, ‘_’);
 * weight;
 * code (allowed only upper case letters, underscore and numbers);
 * image (picture of the medication case).
 */

@Data
public class MedicationDto {

    @Pattern(regexp = "^[a-zA-Z0-9_-]+$", message = "incorrect medication name")
    private String name;
    @Min(value = 0, message = "medication weight must be more than 0 g")
    private int weight;
    @Pattern(regexp = "^[A-Z0-9_]+$", message = "incorrect medication code")
    private String code;

}
