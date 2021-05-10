package com.natwest.sukriti.demoscheduler.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.natwest.sukriti.demoscheduler.entity.UserStories;

@Repository
public interface UserStoriesRepository extends JpaRepository<UserStories, Integer> {

	List<UserStories> findByStatus(String status);
}
