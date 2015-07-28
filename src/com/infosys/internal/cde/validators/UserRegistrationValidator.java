package com.infosys.internal.cde.validators;

import java.util.regex.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.infosys.internal.cde.service.UserService;
import com.infosys.internal.cde.validators.UserForm;

@Component("userRegistrationValidator")
public class UserRegistrationValidator {
	@Autowired
	private UserService userService;
	
	public boolean supports(Class<?> klass) {
		return UserForm.class.isAssignableFrom(klass);
	  }
	
	public void validate(Object target, Errors errors){
		UserForm userForm = (UserForm) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNo","NotEmpty.userForm.phoneNo","phoneNo must not be Empty.");
		// check userEmail errors.....Start..............................
		if((userForm.getUserEmail()).length()>0){
			userForm.setUserEmail((userForm.getUserEmail().trim()));
			Pattern p=Pattern.compile(".+@.+\\.[a-z]+");
			Matcher m=p.matcher(userForm.getUserEmail());
			boolean b=m.matches();
			if(b!=true){
			  errors.rejectValue("userEmail", "userEmail.is.not.valid", "User Email not a well-formed email address.");
			 }else{
			  List userlist=userService.getUserByUserEmail(userForm.getUserEmail());
			  if(userlist!=null && userlist.size()>0){
				  errors.rejectValue("userEmail", "matchUserEmail.memberForm.userEmail", "User Email already exist.");
				}
			 }
	      }
		// check userEmail errors.....End.............................
		if((userForm.getUserGender()).equals("-1")){
		   errors.rejectValue("userGender", "select.userForm.userGender","Select Gender." );
		 }
		if(!(userForm.getPassword()).equals(userForm.getConfirmPassword())){
		  errors.rejectValue("password", "matchpassword.userForm.password","Password and Confirm Password do not match." );
		 }
	}
 }
