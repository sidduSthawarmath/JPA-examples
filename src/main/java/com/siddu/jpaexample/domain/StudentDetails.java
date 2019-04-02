package com.siddu.jpaexample.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="studentdDetails")
public class StudentDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long stdPkId;

	private String name;

	private String fatherName;

	private String phoneNumber;

	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "std_id")
	private List<StudentAddress> address;

	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<StudentAddress> getAddress() {
		return address;
	}

	public void setAddress(List<StudentAddress> address) {
		this.address = address;
	}

	public Long getStdPkId() {
		return stdPkId;
	}

	public void setStdPkId(Long stdPkId) {
		this.stdPkId = stdPkId;
	}
}
