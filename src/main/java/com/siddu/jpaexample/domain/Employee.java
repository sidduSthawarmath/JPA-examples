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

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long pkId;

	private String empId;

	private String empName;

	
	@OneToMany(mappedBy = "employee",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private List<EmpSalary> empSalList;


	public Long getPkId() {
		return pkId;
	}


	public void setPkId(Long pkId) {
		this.pkId = pkId;
	}


	public String getEmpId() {
		return empId;
	}


	public void setEmpId(String empId) {
		this.empId = empId;
	}


	public String getEmpName() {
		return empName;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}


	public List<EmpSalary> getEmpSalList() {
		return empSalList;
	}


	public void setEmpSalList(List<EmpSalary> empSalList) {
		this.empSalList = empSalList;
	}
	
	
	
	
}
