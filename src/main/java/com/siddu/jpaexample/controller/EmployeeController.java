package com.siddu.jpaexample.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.RestController;

import com.siddu.jpaexample.domain.EmpSalary;
import com.siddu.jpaexample.domain.Employee;
import com.siddu.jpaexample.repositories.EmployeeDao;

//OneToMany Bidirectional example
//@RestController
public class EmployeeController implements CommandLineRunner {

	@Autowired
	EmployeeDao employeeDao;

	@Override
	public void run(String... args) throws Exception {

		saveEmpDetails();
		
		findEmpBasedOnSal();
		
		//sum,avg,count,min,max
		aggregateFunExample();

		//order by
		empNameorderByAsc();
		
		//like operator
		getEmpDetLikeOperartor();
		
		//and ,or,in and not in operator
		whereClauseComposite();
		
		//group by use
		getDuplicateMonthSal();
		
		

	}

	public void getDuplicateMonthSal() {
		List<String> dupSalMonth = employeeDao.getDuplicateMonthSal();
		System.out.println(dupSalMonth);
		
	}

	public void whereClauseComposite() {
		
		List<Employee> empSalList = employeeDao.nameStartCharAndSalaryLessThan5k();
		displayData(empSalList);
		
		List<Employee> empSalList1 = employeeDao.nameStartCharOrSalaryLessThan5k();
		displayData(empSalList1);
		
		
		List<Employee> empSalList2 = employeeDao.getEmployeeNameIn();
		displayData(empSalList2);
		
		
		List<Employee> empSalList3 = employeeDao.getEmployeeNameNotIn();
		displayData(empSalList3);
		
		
		
	}

	public void getEmpDetLikeOperartor() {
		List<Employee> empSalList = employeeDao.getEmpDetLikeOperartor("dd");
		displayData(empSalList);
	}

	public void displayData(List<Employee> empSalList) {
		for (Employee emp : empSalList) {
			System.out.println(emp.getEmpName());
		}
	}

	public void empNameorderByAsc() {
		List<Employee> empSalList = employeeDao.empNameorderByAsc();
		displayData(empSalList);

	}

	public void aggregateFunExample() {

		Long count = employeeDao.findEmpCount();

		Double avgSal = employeeDao.findAvgEmpSal();

		Long maxSal = employeeDao.findMaxEmpSal();

		Long minSal = employeeDao.findMinEmpSal();

		Long sumSal = employeeDao.findSumOfEmpSal();

	}

	public void findEmpBasedOnSal() {
		// find employee Whose sal is greater than 9k
		List<EmpSalary> empSalList = employeeDao.findEmpBasedOnSal(9500);

		for (EmpSalary empSal : empSalList) {
			System.out.println(empSal.getEmployee().getEmpName() + " " + empSal.getMonth() + " " + empSal.getSalary());
		}
	}

	public void saveEmpDetails() {

		Employee emp = new Employee();
		emp.setEmpId("123");
		emp.setEmpName("Siddu");

		EmpSalary emplSalary1 = new EmpSalary();
		emplSalary1.setMonth("JAN");
		emplSalary1.setSalary(5000L);
		emplSalary1.setEmployee(emp);

		EmpSalary emplSalary2 = new EmpSalary();
		emplSalary2.setMonth("MARCH");
		emplSalary2.setSalary(5000L);
		emplSalary2.setEmployee(emp);

		List<EmpSalary> empSalList1 = new ArrayList<EmpSalary>();
		empSalList1.add(emplSalary1);
		empSalList1.add(emplSalary2);

		emp.setEmpSalList(empSalList1);
		employeeDao.empSave(emp);

		Employee employee = new Employee();
		employee.setEmpId("124");
		employee.setEmpName("Ramesh");

		EmpSalary emplSal1 = new EmpSalary();
		emplSal1.setMonth("JAN");
		emplSal1.setSalary(10000L);
		emplSal1.setEmployee(employee);

		EmpSalary emplSal2 = new EmpSalary();
		emplSal2.setMonth("FEB");
		emplSal2.setSalary(90000L);
		emplSal2.setEmployee(employee);

		List<EmpSalary> empSalList = new ArrayList<EmpSalary>();
		empSalList.add(emplSal1);
		empSalList.add(emplSal2);

		employee.setEmpSalList(empSalList);

		employeeDao.empSave(employee);

	}

}
