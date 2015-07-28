package com.infosys.internal.cde.dao;

import java.util.List;

import com.infosys.internal.cde.model.Admin;

public interface AdminDao {
	public List<Admin> validateLoginAdmin(String adminEmail, String password);

	public List<Admin> getAdminByAdminEmail(String adminEmail);
}
