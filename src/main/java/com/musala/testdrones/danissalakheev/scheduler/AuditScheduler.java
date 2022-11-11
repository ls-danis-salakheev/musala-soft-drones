package com.musala.testdrones.danissalakheev.scheduler;

import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AuditScheduler {

    @Scheduled(fixedDelayString = "${app.scheduler.batteryAudit.delay}")
    @SchedulerLock(name = "droneBatteryAuditScheduler",
            lockAtLeastFor = "${app.shedLock.lock.atLeast}",
            lockAtMostFor = "${app.shedLock.lock.atMost}")
    void checkDroneBattery() {
        // TODO: 12.11.2022
    }
}
