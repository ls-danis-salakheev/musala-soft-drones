package com.musala.testdrones.danissalakheev.repository;

import com.musala.testdrones.danissalakheev.entity.Drone;
import com.musala.testdrones.danissalakheev.entity.DroneOrder;
import com.musala.testdrones.danissalakheev.enums.DroneOrderState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface DroneOrderRepository extends JpaRepository<DroneOrder, Long> {

    @Query("select do from DroneOrder do join do.drone d where " +
           "do.state = :orderState and d = :drone")
    Optional<DroneOrder> findOrderByStateAndDrone(DroneOrderState orderState, Drone drone);

}
