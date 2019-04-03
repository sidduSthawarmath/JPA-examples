package com.siddu.jpaexample.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.RestController;

import com.siddu.jpaexample.domain.Doctor;
import com.siddu.jpaexample.domain.Patient;
import com.siddu.jpaexample.repositories.DoctorDao;
//Many to many mapping example

//@RestController
public class DoctorController implements CommandLineRunner {

	@Autowired
	private DoctorDao doctorDao;

	@Override
	public void run(String... args) throws Exception {
		saveDoctorAndPatientDetails();

		// get Patient details by doctor
		getPatientDetailsByDoctotId();

	}

	private void getPatientDetailsByDoctotId() {

		Doctor doctor = doctorDao.getPatientDetailsByDoctotId("D123");
		for (Patient patient : doctor.getPatient()) {
			System.out.println(patient.getPatientName() + " " + patient.getDiseases());
		}

	}

	private void saveDoctorAndPatientDetails() {

		Doctor doctor = new Doctor();
		doctor.setDoctorId("D123");
		doctor.setDoctorName("Jayesh");
		doctor.setContactNum("123");

		Patient patient = new Patient();
		patient.setPatientId("P567");
		patient.setPatientName("Raghav");
		patient.setDiseases("fever");

		Set<Doctor> doctorList = new HashSet<Doctor>();
		doctorList.add(doctor);

		patient.setDoctor(doctorList);

		Set<Patient> patientList = new HashSet<Patient>();
		patientList.add(patient);
		doctor.setPatient(patientList);

		doctorDao.save(doctor);

	}

}
