package com.musala.testdrones.danissalakheev.repository;

import com.musala.testdrones.danissalakheev.entity.DroneOrder;
import com.musala.testdrones.danissalakheev.entity.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface MedicationRepository extends JpaRepository<Medication, Long> {

    @Query("select dm.medications from DroneOrder dm " +
           "join dm.drone d where d.serialNumber = :serialNumber")
    List<Medication> findAllByDroneSerialNumber(String serialNumber);

    @Query("select sum(m.weight) from Medication m where m.droneOrder = :droneOrder")
    int calculateTotalWeightByOrder(DroneOrder droneOrder);

}
