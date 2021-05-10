package com.natwest.sukriti.demoscheduler.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "team_member")
@Data
public class TeamMember implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -444657624996029514L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "teammember_id")
	private int teamMemberId;
	@Column(name = "teammember_name")
	private String name;
	@Column(name = "designation")
	private String designation;
	@Column(name = "isNotFree")
	private Boolean isNotFree;
	

}
