package com.musala.testdrones.danissalakheev.repository;

import com.musala.testdrones.danissalakheev.entity.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface MedicationRepository extends JpaRepository<Medication, Long> {

    List<Medication> findAllByDrone_SerialNumber(String serialNumber);

}
