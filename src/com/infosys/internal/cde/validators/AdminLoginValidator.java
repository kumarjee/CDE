package com.infosys.internal.cde.validators;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.infosys.internal.cde.model.Admin;
import com.infosys.internal.cde.service.AdminService;

@Component("adminLoginValidator")
public class AdminLoginValidator {
	@Autowired
	private AdminService adminService;
	
	public boolean supports(Class<?> klass) {
		   return Admin.class.isAssignableFrom(klass);
	  }
	
	public void validate(Object target, Errors errors){
		Admin admin = (Admin) target;
		if ((admin.getAdminEmail() != null) && (admin.getAdminEmail().length() > 0)){
			admin.setAdminEmail(admin.getAdminEmail().trim());
			List adminlist = adminService.validateLoginAdmin(admin.getAdminEmail(),admin.getPassword());			
			if ((adminlist != null) && (adminlist.size() > 0)) {
			  }else {
				errors.rejectValue("adminEmail","notMatchEmailAndPassword.admin.adminEmail","Admin Email or Password you entered is incorrect.");
			  }
		 }
    }
 }
