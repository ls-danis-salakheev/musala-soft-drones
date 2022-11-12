package com.musala.testdrones.danissalakheev.entity;

import com.musala.testdrones.danissalakheev.entity.audit.AuditableEntity;
import com.musala.testdrones.danissalakheev.enums.DroneOrderState;
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
@Table(name = "drone_order")
@ToString(onlyExplicitlyIncluded = true)
public class DroneOrder extends AuditableEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "")
    private DroneOrderState state;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    private Drone drone;

    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "droneOrder", orphanRemoval = true)
    private List<Medication> medications = new ArrayList<>();

    public void addMedication(Medication medication) {
        medications.add(medication);
        medication.setDroneOrder(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DroneOrder other = (DroneOrder) obj;
        return Objects.equals(id, other.getId())
               && Objects.equals(state, other.getState());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, id);
    }
}
