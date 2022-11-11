package com.musala.testdrones.danissalakheev.mapper;

import com.musala.testdrones.danissalakheev.dto.*;
import com.musala.testdrones.danissalakheev.entity.Drone;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class DroneMapper {

    public static final DroneMapper INSTANCE = Mappers.getMapper(DroneMapper.class);

    public abstract Drone map(DroneInputDto droneDto);

    public abstract DroneBatteryDto mapToBatteryDto(Drone drone);

    public abstract DroneInputDto mapToDto(Drone drone);

    public abstract DroneOutDto mapToOutputDto(Drone drone);

    @Mapping(source = "medicationDtoList", target = "medications")
    public abstract LoadedDroneDto mapToLoadedDto(Drone drone, List<MedicationOutDto> medicationDtoList);

}
