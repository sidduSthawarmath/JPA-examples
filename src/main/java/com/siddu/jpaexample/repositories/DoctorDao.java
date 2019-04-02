package com.siddu.jpaexample.repositories;

import java.util.List;

import com.siddu.jpaexample.domain.Doctor;

public interface DoctorDao {

	void save(Doctor doctor);

	Doctor getPatientDetailsByDoctotId(String string);

}
