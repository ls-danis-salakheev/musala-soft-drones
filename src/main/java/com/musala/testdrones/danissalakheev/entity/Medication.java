package com.musala.testdrones.danissalakheev.entity;

import com.musala.testdrones.danissalakheev.entity.audit.AuditableEntity;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@Entity
@ToString(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class Medication extends AuditableEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int weight;

    @Column(nullable = false, unique = true)
    private String code;

    @Lob
    @ToString.Exclude
    @Type(type = "org.hibernate.type.BinaryType")
    private byte[] image;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    private Drone drone;

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Medication other = (Medication) obj;
        return Objects.equals(code, other.getCode())
               && Objects.equals(name, other.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name);
    }
}
