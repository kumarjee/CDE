package com.infosys.internal.cde.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/user/logout")
public class UserLogOutController {
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView logOut(HttpSession session) {
		session.invalidate();
		return new ModelAndView("redirect:userlogin.html");
	}

}
