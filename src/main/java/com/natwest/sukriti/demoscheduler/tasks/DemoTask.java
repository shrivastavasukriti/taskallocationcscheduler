package com.natwest.sukriti.demoscheduler.tasks;

import java.time.Instant;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.natwest.sukriti.demoscheduler.entity.SchedulerLog;
import com.natwest.sukriti.demoscheduler.repository.SchedulerLogRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DemoTask {

	@Autowired()
	private SchedulerLogRepository schedulerLogRepository;

	@Scheduled(fixedDelayString = "${delay}")
	private void run() {
		Instant startTime = Instant.now();
		log.info("I started at !! " + startTime);
		SchedulerLog schedulerLog = new SchedulerLog();
		try {
			Thread.sleep(10000);
			schedulerLog.setStarttime(startTime);
		} catch (InterruptedException e) {
			log.error("I am interrupted !! " + e.getCause());
		}
		Instant endTime = Instant.now();
		log.info("I ended at !! " + endTime);
		schedulerLog.setEndtime(endTime);

		schedulerLogRepository.save(schedulerLog);

	}
}
