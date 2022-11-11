package com.musala.testdrones.danissalakheev.validator.annotation;

import com.musala.testdrones.danissalakheev.validator.ModelValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = ModelValidator.class)
@Documented
public @interface DroneModel {

    String message() default "Unknown model name";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
