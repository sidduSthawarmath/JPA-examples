package com.siddu.jpaexample.repositories;

import com.siddu.jpaexample.domain.StudentDetails;

public interface StudentDao{

	StudentDetails save(StudentDetails studentDetails);

	StudentDetails findByPhoneNumber(String phoneNumber);

	StudentDetails findByHouseNum(String houseNum);

}
