package com.musala.testdrones.danissalakheev.mapper;

import com.musala.testdrones.danissalakheev.dto.MedicationOutDto;
import com.musala.testdrones.danissalakheev.entity.Medication;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class MedicationMapper {

    public static final MedicationMapper INSTANCE = Mappers.getMapper(MedicationMapper.class);

    public abstract MedicationOutDto map(Medication medication);

}
