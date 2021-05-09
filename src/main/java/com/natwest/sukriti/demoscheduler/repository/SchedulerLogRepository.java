package com.natwest.sukriti.demoscheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.natwest.sukriti.demoscheduler.entity.SchedulerLog;

@Repository
public interface SchedulerLogRepository extends JpaRepository<SchedulerLog, Integer> {

}
