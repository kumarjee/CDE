package com.infosys.internal.cde.validators;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.infosys.internal.cde.model.User;
import com.infosys.internal.cde.service.UserService;
import com.infosys.internal.cde.utils.Encryption;

@Component("userLoginValidator")
public class UserLoginValidator {
	@Autowired
	private UserService userService;

	public boolean supports(Class<?> klass) {
		return User.class.isAssignableFrom(klass);
	}

	public void validate(Object target, Errors errors) {
		User user = (User) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userEmail",
				"NotEmpty.user.userEmail", "User Email must not be Empty.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"NotEmpty.user.password", "Password must not be Empty.");

		if ((user.getUserEmail() != null) && (user.getUserEmail().length() > 0)) {
			user.setUserEmail(user.getUserEmail().trim());
			List userlist = userService.validateLoginUser(user.getUserEmail(),Encryption.encrypt(user.getPassword()));
			if ((userlist != null) && (userlist.size() > 0)) {
				List status = userService.getStatusOfUser(user.getUserEmail());
				if ((status != null) && status.size() >0) {
				} else {
					errors.rejectValue("userEmail",
							"notActivated.user.userEmail",
							"Account is not yet activated. Please activate the account by clicking on link provided in activation mail");
				}
			} else {
				errors.rejectValue("userEmail",
						"notMatchEmailAndPassword.user.userEmail",
						"User Email or Password you entered is incorrect.");
			}

		}

	}

}
