package com.natwest.sukriti.demoscheduler.service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.natwest.sukriti.demoscheduler.entity.SchedulerLog;
import com.natwest.sukriti.demoscheduler.entity.TeamMember;
import com.natwest.sukriti.demoscheduler.entity.UserStories;
import com.natwest.sukriti.demoscheduler.repository.SchedulerLogRepository;
import com.natwest.sukriti.demoscheduler.repository.TeamMemberRepository;
import com.natwest.sukriti.demoscheduler.repository.UserStoriesRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TaskAllocationService {

	@Autowired()
	private SchedulerLogRepository schedulerLogRepository;

	@Autowired()
	private TeamMemberRepository teamMemberRepository;

	@Autowired()
	private UserStoriesRepository userStoriesRepository;

	private Instant startTime = null;
	private Instant endTime = null;
	private Instant interval = null;
	private String status = "NEW";

	/**
	 * Allocate tasks to teamMembers 
	 * (Dummy Implementation for Coding Test Purpose)
	 */
	@Scheduled(fixedDelayString = "${delay}")
	private void allocateTask() {
		startTime = Instant.now();
		log.info("allocateTask method invoked !! " + startTime);
		List<TeamMember> teamMembers = teamMemberRepository.findAll();
		List<UserStories> newUserStories = userStoriesRepository.findByStatus(status);
		interval = Instant.now();
		log.info("interval after getting data from db !! " + interval);

		for (UserStories userStory : newUserStories) {
			if (!userStory.isAllocated()) {
				for (TeamMember teamMember : teamMembers) {
					if (teamMember.getDesignation().equalsIgnoreCase("Developer")
							&& Objects.isNull(userStory.getTeamMember())&& !teamMember.getIsNotFree()) {
						userStory.setTeamMember(teamMember);
						userStory.setAllocated(Boolean.TRUE);
						teamMember.setIsNotFree(Boolean.TRUE);
						break;
					}
					if (teamMember.getDesignation().equalsIgnoreCase("Lead")
							&& Objects.isNull(userStory.getTeamMember())&& !teamMember.getIsNotFree()) {
						userStory.setTeamMember(teamMember);
						userStory.setAllocated(Boolean.TRUE);
						teamMember.setIsNotFree(Boolean.TRUE);
						break;
					}
				}
			}
		}
		userStoriesRepository.saveAll(newUserStories);
		teamMemberRepository.saveAll(teamMembers);

		endTime = Instant.now();
		log.info("allocateTask method ended !! " + endTime);

		addToSchedulerLog();

	}

	/**
	 * This method adds logs of the scheduler to h2 db
	 */
	private void addToSchedulerLog() {
		SchedulerLog schedulerLog = new SchedulerLog();
		schedulerLog.setStarttime(startTime);
		schedulerLog.setEndtime(endTime);
		schedulerLog.setIntervallog(interval);
		schedulerLogRepository.save(schedulerLog);
	}
}
