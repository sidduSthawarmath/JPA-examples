package com.siddu.jpaexample.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.siddu.jpaexample.domain.StudentDetails;

@Repository
@Transactional
public class StudentDaoImpl implements StudentDao {

	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public StudentDetails save(StudentDetails studentDetails) {
		entityManager.persist(studentDetails);
		return null;
	}

	@Override
	public StudentDetails findByPhoneNumber(String phoneNumber) {
		Query query = entityManager.createQuery("from StudentDetails where phoneNumber='" + phoneNumber + "'");
		query.getSingleResult();
		return (StudentDetails) query.getSingleResult();
	}

	@Override
	public StudentDetails findByHouseNum(String houseNum) {
		Query query = entityManager.createQuery(
				"select distinct std FROM  StudentDetails as std inner join std.address as addr where addr.houseNum = :dept_name");
		query.setParameter("dept_name", houseNum);
		List<StudentDetails> std = (List<StudentDetails>) query.getResultList();

		for (StudentDetails std1 : std) {
			System.out.println(std1.getFatherName());
		}
		return null;
	}

}
