package com.musala.testdrones.danissalakheev.repository.projection;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * Class-Based entity projection for define properties
 */
@Data
@RequiredArgsConstructor
public class DroneBatteryLevelProjection {

    private final String serialNumber;
    private final int capacity;

}
