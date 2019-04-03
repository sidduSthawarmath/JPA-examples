package com.siddu.jpaexample.controller;

import java.util.List;

import javax.persistence.Tuple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.RestController;

import com.siddu.jpaexample.projections.EmployeeProjection;
import com.siddu.jpaexample.repositories.EmployeeDao;

//@RestController
public class Projections implements CommandLineRunner {

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public void run(String... args) throws Exception {

		/*
		 * your persistence provider, e.g., Hibernate or EclipseLink, need to handle the
		 * DTO projection. It does that when it processes the result set of your query.
		 * Instead of mapping each row to an Object[], your persistence provider calls
		 * the constructor of your DTO to instantiate a new object. So, you need to make
		 * sure that your DTO always has a constructor that matches the columns selected
		 * by your query
		 */
		getEmployeeAndSalDetails();

		/*
		 * if you only want to execute a query and immediately process the result. In
		 * that case, a Tuple projection might be the easier option.JPA’s Tuple
		 * interface provides a generic and comfortable way to access the elements of a
		 * query result. You can use it to access the elements by their index or alias,
		 * and you can provide additional type information to cast them automatically.
		 */
		getEmployeeAndSalDetailsUsingTuple();

	}

	private void getEmployeeAndSalDetailsUsingTuple() {
		List<Tuple> empTupleProjection = employeeDao.getEmployeeAndSalDetailsUsingTuple();
		for (Tuple tuple : empTupleProjection) {
			System.out.println("-------"+tuple.get("empId")+" details---------");
			System.out.println("Emp Id: "+tuple.get("empId"));
			System.out.println("emp Name: "+tuple.get("empName"));
			System.out.println("month: "+tuple.get("month"));
			System.out.println("salary: "+tuple.get("salary"));
			System.out.println("----------------------------------------------\n\n");
		}
	}

	private void getEmployeeAndSalDetails() {
		List<EmployeeProjection> empProjection = employeeDao.getEmployeeAndSalDetails();
		System.out.println(empProjection);

	}

}
