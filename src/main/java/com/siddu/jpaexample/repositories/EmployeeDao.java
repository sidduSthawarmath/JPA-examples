package com.siddu.jpaexample.repositories;

import java.util.List;

import com.siddu.jpaexample.domain.EmpSalary;
import com.siddu.jpaexample.domain.Employee;

public interface EmployeeDao {

	public void empSave(Employee emp);

	public List<EmpSalary> findEmpBasedOnSal(int i);

	public Long findEmpCount();

	public Double findAvgEmpSal();

	public Long findMaxEmpSal();

	public Long findMinEmpSal();

	public Long findSumOfEmpSal();

	public List<Employee> empNameorderByAsc();

	public List<Employee> getEmpDetLikeOperartor(String string);

	public List<Employee> nameStartCharAndSalaryLessThan5k();

	public List<Employee> nameStartCharOrSalaryLessThan5k();

	public List<Employee> getEmployeeNameIn();

	public List<Employee> getEmployeeNameNotIn();

	public List<String> getDuplicateMonthSal();
	
}
