package com.musala.testdrones.danissalakheev.scheduler;

import com.musala.testdrones.danissalakheev.repository.DroneRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class AuditScheduler {

    @Value("${app.scheduler.batteryAudit.logMessage}")
    private String batteryLogMessage;

    private final DroneRepository droneRepository;

    @Scheduled(fixedDelayString = "${app.scheduler.batteryAudit.delay}")
    @SchedulerLock(name = "droneBatteryAuditScheduler",
            lockAtLeastFor = "${app.shedLock.lock.atLeast}",
            lockAtMostFor = "${app.shedLock.lock.atMost}")
    public void checkAndLogDroneBatteryCapacity() {
        droneRepository
                .findAllBatteryProjections()
                .forEach(drone -> log.info(batteryLogMessage,
                        drone.getSerialNumber(),
                        drone.getCapacity(), drone.getState()));
    }
}
