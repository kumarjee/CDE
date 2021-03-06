package com.infosys.internal.cde.dao;

import java.util.List;

import com.infosys.internal.cde.model.Results;
import com.infosys.internal.cde.model.User;

public interface UserDao {
	
	public List<User> listUsers();	
	public void saveUser(User user );
	public List<User> getUserByUserEmail(String userEmail);
	public List<User> validateLoginUser(String userEmail,String password);
	public List<User> getStatusOfUser(String userEmail);
	public void activateUser(int token);
	public List<Results> getResultOfUser(String userEmail);
	
}
