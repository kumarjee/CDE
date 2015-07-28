package com.infosys.internal.cde.service;

import java.util.List;

import com.infosys.internal.cde.model.User;

public interface UserService {

	public List<User> listUsers();

	public void saveUser(User user);

	public List<User> getUserByUserEmail(String userEmail);

	public List<User> validateLoginUser(String userEmail, String password);
}
