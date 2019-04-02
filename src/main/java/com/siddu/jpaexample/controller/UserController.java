package com.siddu.jpaexample.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.RestController;

import com.siddu.jpaexample.domain.User;
import com.siddu.jpaexample.domain.UserLoggedInDetails;
import com.siddu.jpaexample.repositories.UserDao;

//OneToOne mapping example
@RestController
public class UserController implements CommandLineRunner {

	@Autowired
	private UserDao userDao;

	@Override
	public void run(String... args) throws Exception {

		saveUserDetails();
		
		findTodayLoggedInUser();
		

	}

	private void findTodayLoggedInUser() {
	  List<User> loggedInUserList=userDao.findTodayLoggedInUser();
		
	}

	private void saveUserDetails() {

		User user = new User();
		user.setUserName("Ram");
		user.setUserPwd("ram*!23");

		UserLoggedInDetails userLoggedInDetails = new UserLoggedInDetails();
		userLoggedInDetails.setLastLogOutDateTime(new Date());
		userLoggedInDetails.setLoginDateTime(new Date());
		userLoggedInDetails.setUser(user);
		user.setUserLoggedInDetails(userLoggedInDetails);
		userDao.saveUser(user);

		User user1 = new User();
		user1.setUserName("Ganesh");
		user1.setUserPwd("ganesh321");

		UserLoggedInDetails userLoggedInDetails1 = new UserLoggedInDetails();
		userLoggedInDetails1.setLastLogOutDateTime(new Date());
		userLoggedInDetails1.setLoginDateTime(new Date());
		userLoggedInDetails1.setUser(user1);

		user1.setUserLoggedInDetails(userLoggedInDetails1);

		userDao.saveUser(user1);

	}

}
