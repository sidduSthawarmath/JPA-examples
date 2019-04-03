package com.siddu.jpaexample.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.siddu.jpaexample.domain.EmpSalary;
import com.siddu.jpaexample.domain.Employee;
import com.siddu.jpaexample.projections.EmployeeProjection;

@Transactional
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void empSave(Employee emp) {
		entityManager.persist(emp);
	}

	@Override
	public List<EmpSalary> findEmpBasedOnSal(int sal) {

		Query query = entityManager.createQuery(
				"select distinct empSal from EmpSalary as empSal inner join empSal.employee as empSalList where empSal.salary >="
						+ sal);
		return query.getResultList();
	}

	@Override
	public Long findEmpCount() {
		Query query = entityManager.createQuery("select count(emp) from Employee as emp");
		return (Long) query.getSingleResult();
	}

	@Override
	public Double findAvgEmpSal() {
		Query query = entityManager.createQuery(
				"select AVG(empSal.salary) from EmpSalary as empSal inner join empSal.employee as empSalList");
		return (Double) query.getSingleResult();
	}

	@Override
	public Long findMaxEmpSal() {
		Query query = entityManager.createQuery(
				"select max(empSal.salary) from EmpSalary as empSal inner join empSal.employee as empSalList");
		return (Long) query.getSingleResult();
	}

	@Override
	public Long findMinEmpSal() {
		Query query = entityManager.createQuery(
				"select min(empSal.salary) from EmpSalary as empSal inner join empSal.employee as empSalList");
		return (Long) query.getSingleResult();
	}

	@Override
	public Long findSumOfEmpSal() {
		Query query = entityManager.createQuery(
				"select sum(empSal.salary) from EmpSalary as empSal inner join empSal.employee as empSalList");
		return (Long) query.getSingleResult();
	}

	@Override
	public List<Employee> empNameorderByAsc() {
		Query query = entityManager.createQuery("from Employee as emp order by emp.empName asc");
		return query.getResultList();
	}

	@Override
	public List<Employee> getEmpDetLikeOperartor(String name) {
		Query query = entityManager.createQuery("from Employee as emp where emp.empName like '%" + name + "%'");
		return query.getResultList();
	}

	@Override
	public List<Employee> nameStartCharAndSalaryLessThan5k() {
		Query query = entityManager.createQuery(
				"select distinct emp from Employee as emp inner join emp.empSalList as empSal  where emp.empName like 'sid%' and empSal.salary<=5000");
		return query.getResultList();
	}

	@Override
	public List<Employee> nameStartCharOrSalaryLessThan5k() {
		Query query = entityManager.createQuery(
				"select distinct emp from Employee as emp inner join emp.empSalList as empSal  where emp.empName like 'r%' or empSal.salary<=5000");
		return query.getResultList();
	}

	@Override
	public List<Employee> getEmployeeNameIn() {
		Query query = entityManager
				.createQuery("select distinct emp from Employee as emp where emp.empName in ('siddu')");
		return query.getResultList();
	}

	@Override
	public List<Employee> getEmployeeNameNotIn() {
		Query query = entityManager
				.createQuery("select distinct emp from Employee as emp where emp.empName not in ('siddu')");
		return query.getResultList();
	}

	@Override
	public List<String> getDuplicateMonthSal() {
		Query query = entityManager.createQuery(
				"select empSal.month from Employee as emp inner join emp.empSalList as empSal  group by empSal.month having count(empSal.month)>1");
		return query.getResultList();
	}

	@Override
	public List<EmployeeProjection> getEmployeeAndSalDetails() {
		Query query = entityManager.createQuery(
				"select new com.siddu.jpaexample.projections.EmployeeProjection(emp.empId,emp.empName,empSal.month,empSal.salary) from Employee as emp inner join emp.empSalList as empSal");
		return query.getResultList();
	}

	@Override
	public List<Tuple> getEmployeeAndSalDetailsUsingTuple() {
		Query query = entityManager.createQuery(
				"select emp.empId as empId,emp.empName as empName,empSal.month as month,empSal.salary as salary from Employee as emp inner join emp.empSalList as empSal",
				Tuple.class);
		return query.getResultList();
	}

	// Criteria for fetch all records
	public List<Employee> getAllEmpUsingCreteria() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Employee> creteria = builder.createQuery(Employee.class);
		Root<Employee> root = creteria.from(Employee.class);
		creteria.where(builder.and(builder.equal(root.get("empName"), "siddu")));

		List<Employee> employeeList = entityManager.createQuery(creteria).getResultList();

		return employeeList;
	}
}
