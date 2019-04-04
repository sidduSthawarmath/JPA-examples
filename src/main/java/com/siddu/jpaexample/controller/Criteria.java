package com.siddu.jpaexample.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.RestController;

import com.siddu.jpaexample.domain.EmpSalary;
import com.siddu.jpaexample.domain.Employee;
import com.siddu.jpaexample.repositories.EmployeeDao;

@RestController
public class Criteria implements CommandLineRunner{


	
	/*
	 * JPQL queries are defined as strings, similarly to SQL. JPA criteria queries,
	 * on the other hand, are defined by instantiation of Java objects that
	 * represent query elements.
	 * 
	 * A major advantage of using the criteria API is that errors can be detected
	 * earlier, during compilation rather than at runtime. On the other hand, for
	 * many developers string based JPQL queries, which are very similar to SQL
	 * queries, are easier to use and understand.
	 * 
	 * For simple static queries - string based JPQL queries (e.g. as named queries)
	 * may be preferred. For dynamic queries that are built at runtime - the
	 * criteria API may be preferred.
	 * 
	 * For example, building a dynamic query based on fields that a user fills at
	 * runtime in a form that contains many optional fields - is expected to be
	 * cleaner when using the JPA criteria API, because it eliminates the need for
	 * building the query using many string concatenation operations.
	 * 
	 * String based JPQL queries and JPA criteria based queries are equivalent in
	 * power and in efficiency. Therefore, choosing one method over the other is
	 * also a matter of personal preference.
	 */
	
	
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public void run(String... args) throws Exception {
		saveEmpDetails();
		
		getAllEmpUsingCreteria();
	}

	
	
	public void getAllEmpUsingCreteria() {
	List<Employee> empList=	employeeDao.getAllEmpUsingCreteria();
		
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
