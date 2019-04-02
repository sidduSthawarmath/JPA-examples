package com.siddu.jpaexample.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class UserLoggedInDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long pkId;

	private Date loginDateTime;

	private Date lastLogOutDateTime;

	@OneToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	public Long getPkId() {
		return pkId;
	}

	public void setPkId(Long pkId) {
		this.pkId = pkId;
	}

	public Date getLoginDateTime() {
		return loginDateTime;
	}

	public void setLoginDateTime(Date loginDateTime) {
		this.loginDateTime = loginDateTime;
	}

	public Date getLastLogOutDateTime() {
		return lastLogOutDateTime;
	}

	public void setLastLogOutDateTime(Date lastLogOutDateTime) {
		this.lastLogOutDateTime = lastLogOutDateTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
