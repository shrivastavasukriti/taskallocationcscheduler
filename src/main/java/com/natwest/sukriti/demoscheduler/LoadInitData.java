package com.natwest.sukriti.demoscheduler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.natwest.sukriti.demoscheduler.entity.TeamMember;
import com.natwest.sukriti.demoscheduler.entity.UserStories;
import com.natwest.sukriti.demoscheduler.repository.TeamMemberRepository;
import com.natwest.sukriti.demoscheduler.repository.UserStoriesRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class LoadInitData {

	@Autowired
	private TeamMemberRepository teamMemberRepository;
	
	@Autowired
	private UserStoriesRepository userStoriesRepository;
	
	@EventListener(ApplicationReadyEvent.class)
	public void loadInitTeamMemberDataToH2() {
		log.info("loadInitDataToH2 invoked !!");
		List<TeamMember> listTeamMember = new ArrayList<>();
		TeamMember teamMember1 = new TeamMember();
		teamMember1.setDesignation("Developer");
		teamMember1.setName("Member 1");
		teamMember1.setIsNotFree(Boolean.FALSE);
		TeamMember teamMember2 = new TeamMember();
		teamMember2.setDesignation("Developer");
		teamMember2.setName("Member 2");
		teamMember2.setIsNotFree(Boolean.FALSE);
		TeamMember teamMember3 = new TeamMember();
		teamMember3.setDesignation("Lead");
		teamMember3.setName("Member 3");
		teamMember3.setIsNotFree(Boolean.FALSE);
		TeamMember teamMember4 = new TeamMember();
		teamMember4.setDesignation("Manager");
		teamMember4.setName("Member 4");
		teamMember4.setIsNotFree(Boolean.FALSE);
		listTeamMember.add(teamMember1);
		listTeamMember.add(teamMember2);
		listTeamMember.add(teamMember3);
		listTeamMember.add(teamMember4);
		teamMemberRepository.saveAll(listTeamMember);
		log.info("TeamMembers loaded to H2 !!");
	}
		
	@EventListener(ApplicationReadyEvent.class)
	public void loadInitUserStoriesDataToH2() {
		log.info("loadInitUserStoriesDataToH2 invoked !!");
		List<UserStories> listUserStories = new ArrayList<>();
		UserStories userStories1 = new UserStories();
		userStories1.setDaysEstimated(4);
		userStories1.setStoryName("Initialize Project");
		userStories1.setStatus("NEW");
		userStories1.setAllocated(Boolean.FALSE);
		UserStories userStories2 = new UserStories();
		userStories2.setDaysEstimated(2);
		userStories2.setStoryName("Initialize Jira");
		userStories2.setStatus("NEW");
		userStories2.setAllocated(Boolean.FALSE);
		UserStories userStories3 = new UserStories();
		userStories3.setDaysEstimated(3);
		userStories3.setStoryName("Create front page");
		userStories3.setStatus("NEW");
		userStories3.setAllocated(Boolean.FALSE);
		UserStories userStories4 = new UserStories();
		userStories4.setDaysEstimated(1);
		userStories4.setStoryName("Create get request of REST API");
		userStories4.setStatus("NEW");
		userStories4.setAllocated(Boolean.FALSE);
		UserStories userStories5 = new UserStories();
		userStories5.setStoryName("Work on defects");
		userStories5.setStatus("IN-PROGRESS");
		listUserStories.add(userStories1);
		listUserStories.add(userStories2);
		listUserStories.add(userStories3);
		listUserStories.add(userStories4);
		listUserStories.add(userStories5);
		userStoriesRepository.saveAll(listUserStories);
		log.info("UserStories loaded to H2 !!");
	}
		

}
