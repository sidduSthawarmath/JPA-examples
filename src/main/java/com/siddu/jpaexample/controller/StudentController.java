package com.siddu.jpaexample.controller;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.RestController;

import com.siddu.jpaexample.domain.StudentAddress;
import com.siddu.jpaexample.domain.StudentDetails;
import com.siddu.jpaexample.repositories.StudentDao;


//OneToMany Unidirectional example
//@RestController
public class StudentController implements CommandLineRunner {

	@Autowired
	private StudentDao studentDao;

	@Override
	public void run(String... args) throws Exception {

		// Save student details
		save();

		// Find student details by phone number
		String phoneNum = "12345678";
		findByStudentphoneNum(phoneNum);
		
		//Find details
		findByHouseNum("2134");
	}

	public StudentDetails save() {
		// Student details
		StudentDetails studentDetails = new StudentDetails();
		studentDetails.setName("Raghav");
		studentDetails.setFatherName("Ganesh");
		studentDetails.setPhoneNumber("12345678");

		// Address set
		List<StudentAddress> addressList = new ArrayList<StudentAddress>();

		StudentAddress stdAddress1 = new StudentAddress();
		stdAddress1.setArea("Vijay nagar");
		stdAddress1.setHouseNum("2134");
		stdAddress1.setPinCode(585123);
		//stdAddress1.setStdDet(studentDetails);

		StudentAddress stdAddress2 = new StudentAddress();
		stdAddress2.setArea("Basaveshwara nagar");
		stdAddress2.setHouseNum("2134");
		stdAddress2.setPinCode(585342);
		//stdAddress2.setStdDet(studentDetails);

		addressList.add(stdAddress1);
		addressList.add(stdAddress2);

		studentDetails.setAddress(addressList);

		studentDetails = studentDao.save(studentDetails);
		return studentDetails;
	}

	public void findByStudentphoneNum(String phoneNumber) {
		StudentDetails student = studentDao.findByPhoneNumber(phoneNumber);
		System.out.println(student);
		//System.out.println(student.getAddress());
	}
	
	
	public void findByHouseNum(String houseNum) {
		StudentDetails student = studentDao.findByHouseNum(houseNum);
		System.out.println(student);
		//System.out.println(student.getAddress());
	}
	
	
	
	
}
