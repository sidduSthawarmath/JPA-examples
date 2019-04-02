package com.siddu.jpaexample.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long pkId;

	private String userName;

	private String userPwd;

	@OneToOne(fetch = javax.persistence.FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "user")
	private UserLoggedInDetails userLoggedInDetails;

	public Long getPkId() {
		return pkId;
	}

	public void setPkId(Long pkId) {
		this.pkId = pkId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public UserLoggedInDetails getUserLoggedInDetails() {
		return userLoggedInDetails;
	}

	public void setUserLoggedInDetails(UserLoggedInDetails userLoggedInDetails) {
		this.userLoggedInDetails = userLoggedInDetails;
	}

}
