package com.siddu.jpaexample.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="student_address")
public class StudentAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "std_add_pk_id")
	private Long stdAdrPkId;

	private String houseNum;

	private String area;

	private Integer pinCode;

	
	public String getHouseNum() {
		return houseNum;
	}

	public void setHouseNum(String houseNum) {
		this.houseNum = houseNum;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Integer getPinCode() {
		return pinCode;
	}

	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}

	public Long getStdAdrPkId() {
		return stdAdrPkId;
	}

	public void setStdAdrPkId(Long stdAdrPkId) {
		this.stdAdrPkId = stdAdrPkId;
	}
	

}
