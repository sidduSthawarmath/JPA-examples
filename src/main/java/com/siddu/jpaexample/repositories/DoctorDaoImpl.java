package com.siddu.jpaexample.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.siddu.jpaexample.domain.Doctor;

@Transactional
@Repository
public class DoctorDaoImpl implements DoctorDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Doctor doctor) {
		entityManager.persist(doctor);

	}

	@Override
	public Doctor getPatientDetailsByDoctotId(String doctorId) {
		Query query = entityManager.createQuery("from Doctor as doc where doc.doctorId= :doctorId");
		query.setParameter("doctorId", doctorId);
		return (Doctor) query.getSingleResult();
	}

}
