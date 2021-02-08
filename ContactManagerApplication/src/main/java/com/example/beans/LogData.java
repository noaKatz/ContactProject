package com.example.beans;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "logData")
public class LogData {
	@Id
	private int id;
	@Column
	private String action;
	@Column
	private Date actionTime;

	public LogData(int id, String action, Date actionTime) {
		super();
		this.id = id;
		this.action = action;
		this.actionTime = actionTime;
	}

	public LogData() {
		super();
	}

	public LogData(String action, Date actionTime) {
		super();
		this.action = action;
		this.actionTime = actionTime;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Date getActionTime() {
		return actionTime;
	}

	public void setActionTime(Date actionTime) {
		this.actionTime = actionTime;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "LogData [id=" + id + ", action=" + action + ", actionTime=" + actionTime + "]";
	}

}
