package com.infosys.internal.cde.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.infosys.internal.cde.model.User;
import com.infosys.internal.cde.service.UserService;
import com.infosys.internal.cde.validators.UserLoginValidator;

import java.util.Map;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/user/userlogin")
public class UserLoginController {

	@Autowired
	private UserLoginValidator userLoginValidator;
	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showUserLogin(Map model, HttpSession session) {
		if (session.getAttribute("userEmail") == null) {
			User user = new User();
			model.put("user", user);
			return new ModelAndView("/user/userlogin");
		} else {
			return new ModelAndView("redirect:selectpaper.html");
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView processUserLogin(@Valid User user,
			BindingResult result, Map model, HttpSession session) {
		userLoginValidator.validate(user, result);
		if (result.hasErrors()) {
			return new ModelAndView("/user/userlogin");
		}
		List userlist = userService.getUserByUserEmail(user.getUserEmail());
		if (userlist != null && userlist.size() > 0) {
			User user1 = new User();
			user1 = (User) userlist.get(0);
			session.setAttribute("userName", user1.getUserName());
		}
		session.setAttribute("userEmail", user.getUserEmail());
		return new ModelAndView("redirect:selectpaper.html");
	}
}
