package com.natwest.sukriti.demoscheduler.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "user_stories")
@Data
public class UserStories implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6358367633010636521L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "story_id")
	private int storyId;
	@Column(name = "days_estimated")
	private int daysEstimated;
	@Column(name = "story_name")
	private String storyName;
	@Column(name = "status")
	private String status;
	@Column(name = "allocated")
	private boolean allocated;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "teammember_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private TeamMember teamMember;

}
