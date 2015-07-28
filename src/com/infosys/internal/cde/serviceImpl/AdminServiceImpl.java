package com.infosys.internal.cde.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.infosys.internal.cde.dao.AdminDao;
import com.infosys.internal.cde.model.Admin;
import com.infosys.internal.cde.service.AdminService;

@Service("adminService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;

	@Override
	public List<Admin> validateLoginAdmin(String adminEmail, String password) {
		return adminDao.validateLoginAdmin(adminEmail, password);
	}

	@Override
	public List<Admin> getAdminByAdminEmail(String adminEmail) {
		return adminDao.getAdminByAdminEmail(adminEmail);
	}
}
