package com.infosys.internal.cde.service;

import java.util.List;

import com.infosys.internal.cde.model.Admin;

public interface AdminService {
	public List<Admin> validateLoginAdmin(String adminEmail, String password);

	public List<Admin> getAdminByAdminEmail(String adminEmail);
}
