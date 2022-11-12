package com.musala.testdrones.danissalakheev.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Each Medication has:
 * <p>
 * name (allowed only letters, numbers, ‘-‘, ‘_’);
 * weight;
 * code (allowed only upper case letters, underscore and numbers);
 * image (picture of the medication case).
 */

@Data
public class MedicationDto {

    @NotNull(message = "medication name must be not null")
    @NotBlank(message = "check medication name, probably it's blank")
    @Pattern(regexp = "^[a-zA-Z0-9_-]+$", message = "incorrect medication name")
    private String name;
    @Min(value = 0L, message = "medication weight must be more than 0 g")
    private int weight;
    @NotNull(message = "medication code must be not null")
    @NotBlank(message = "check medication code, probably it's blank")
    @Pattern(regexp = "^[A-Z0-9_]+$", message = "incorrect medication code")
    private String code;
    @JsonIgnore
    private byte[] imageBytes;
}
