package com.siddu.jpaexample.repositories;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.siddu.jpaexample.domain.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void saveUser(User user) {
		entityManager.persist(user);
	}

	@Override
	public List<User> findTodayLoggedInUser() {
		Query query = entityManager.createQuery(
				"select distinct  user from User as user inner join user.userLoggedInDetails as userLoggedInDet "
						+ "where userLoggedInDet.loginDateTime between '2019-4-2' and '2019-4-2'");
		return query.getResultList();
	}
}
