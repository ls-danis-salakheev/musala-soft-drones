package com.musala.testdrones.danissalakheev.entity;

import java.io.Serializable;

public interface BaseEntity <T extends Serializable> {

    T getId();

    void setId(T id);

}
