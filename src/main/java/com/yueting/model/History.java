package com.yueting.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "yt_history")
public class History {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "userid")
	private Integer userId;
	
	@Column(name = "iterm_id")
	private Integer itermId;
	
	@Column(name = "radio_id")
	private Integer radioId;
	
	@Column(name = "date_time")
	private Date dateTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getItermId() {
		return itermId;
	}

	public void setItermId(Integer itermId) {
		this.itermId = itermId;
	}

	public Integer getRadioId() {
		return radioId;
	}

	public void setRadioId(Integer radioId) {
		this.radioId = radioId;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
}
