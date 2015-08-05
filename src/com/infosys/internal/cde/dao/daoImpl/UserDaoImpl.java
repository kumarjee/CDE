package com.infosys.internal.cde.dao.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infosys.internal.cde.dao.UserDao;
import com.infosys.internal.cde.model.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;

	public List<User> listUsers() {
		return (List<User>) sessionFactory.getCurrentSession().createCriteria(
				User.class).list();

	}

	@Override
	public void saveUser(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);

	}

	@Override
	public List<User> getUserByUserEmail(String userEmail) {
		return sessionFactory.getCurrentSession().createQuery(
				"from User where userEmail=:userEmail").setString("userEmail",
				userEmail).list();
	}

	@Override
	public List<User> validateLoginUser(String userEmail, String password) {
		return sessionFactory.getCurrentSession().createQuery(
				"from User where userEmail=:userEmail and password=:password")
				.setString("userEmail", userEmail).setString("password",
						password).list();
	}

	@Override
	public List<User> getStatusOfUser(String userEmail) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery(
				"from User where status='Y' and userEmail=:userEmail")
				.setString("userEmail", userEmail).list();
	}

	@Override
	public void activateUser(int token) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().createSQLQuery("update user set status='Y' where random =:token").setInteger("token", token)
		.executeUpdate();
		
	}

		

}
