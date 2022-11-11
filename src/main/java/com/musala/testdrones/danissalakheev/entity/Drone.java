package com.musala.testdrones.danissalakheev.entity;

import com.musala.testdrones.danissalakheev.entity.audit.AuditableEntity;
import com.musala.testdrones.danissalakheev.enums.DroneModel;
import com.musala.testdrones.danissalakheev.enums.DroneState;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
public class Drone extends AuditableEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String serialNumber;

    @Enumerated(EnumType.STRING)
    @Column(length = 32)
    private DroneModel model;

    @Column(nullable = false)
    private int weightLimit;

    @Column(nullable = false)
    private int batteryCapacity;

    @Enumerated(EnumType.STRING)
    @Column(length = 32)
    private DroneState state;

    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "drone", orphanRemoval = true)
    private List<Medication> medications = new ArrayList<>();

    public void addMedication(Medication medication) {
        medications.add(medication);
        medication.setDrone(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Drone other = (Drone) obj;
        return Objects.equals(serialNumber, other.getSerialNumber());
    }

    @Override
    public int hashCode() {
        return serialNumber.hashCode();
    }
}
