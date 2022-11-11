package com.musala.testdrones.danissalakheev.repository;

import com.musala.testdrones.danissalakheev.entity.Drone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface DroneRepository extends JpaRepository<Drone, Long> {

}
