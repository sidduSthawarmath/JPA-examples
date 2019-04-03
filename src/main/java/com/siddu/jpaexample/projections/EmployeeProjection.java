package com.siddu.jpaexample.projections;

public class EmployeeProjection {

	private String empId;

	private String empName;

	private String month;

	private Long salary;

	public EmployeeProjection(String empId, String empName, String month, Long salary) {
		this.empId = empId;
		this.empName = empName;
		this.month = month;
		this.salary = salary;
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

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EmployeeProjection [empId=" + empId + ", empName=" + empName + ", month=" + month + ", salary=" + salary
				+ "]";
	}

}
