package com.musala.testdrones.danissalakheev.repository.projection;

import com.musala.testdrones.danissalakheev.enums.DroneState;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * Class-Based entity projection for define properties
 */
@Data
@RequiredArgsConstructor
public class DroneBatteryLevelProjection {

    private final String serialNumber;
    private final DroneState state;
    private final int capacity;

}
