package com.natwest.sukriti.demoscheduler.entity;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="schedulerlog")
@Data
public class SchedulerLog implements Serializable{
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4281118871875837731L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
    private Instant starttime;
    private Instant endtime;
    
}
