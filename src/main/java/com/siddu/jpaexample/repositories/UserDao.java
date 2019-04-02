package com.siddu.jpaexample.repositories;

import java.util.List;

import com.siddu.jpaexample.domain.User;

public interface UserDao {

	public void saveUser(User user);

	public List<User> findTodayLoggedInUser();

}
