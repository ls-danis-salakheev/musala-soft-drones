package com.musala.testdrones.danissalakheev.enums;


import java.util.Set;

public enum DroneState {

    IDLE,
    LOADING,
    LOADED,
    DELIVERING,
    DELIVERED,
    RETURNING;

    public static Set<DroneState> LOADABLE_STATES = Set.of(IDLE, LOADING);

}
