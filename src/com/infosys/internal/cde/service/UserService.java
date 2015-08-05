package com.infosys.internal.cde.service;

import java.util.List;

import com.infosys.internal.cde.model.User;

public interface UserService {

	public List<User> listUsers();

	public void saveUser(User user);
	
	public void sendActivationMail(User user);

	public List<User> getUserByUserEmail(String userEmail);
	
	public boolean ValidateEmailDomain(String userEmail);

	public List<User> validateLoginUser(String userEmail, String password);

	public List<User> getStatusOfUser(String userEmail);

	public void activateUser(int random);

	
}
