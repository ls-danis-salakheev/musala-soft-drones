package com.musala.testdrones.danissalakheev.validator;

import com.musala.testdrones.danissalakheev.validator.annotation.DroneModel;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ModelValidator implements ConstraintValidator<DroneModel, com.musala.testdrones.danissalakheev.enums.DroneModel> {

    @Override
    public boolean isValid(com.musala.testdrones.danissalakheev.enums.DroneModel input,
                           ConstraintValidatorContext constraintValidatorContext) {
        for (var model : com.musala.testdrones.danissalakheev.enums.DroneModel.values()) {
            if(model.equals(input)) {
                return true;
            }
        }
        return false;
    }
}
