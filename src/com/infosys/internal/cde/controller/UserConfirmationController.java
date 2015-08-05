package com.infosys.internal.cde.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import com.infosys.internal.cde.service.UserService;


@Controller
@RequestMapping("user/userconfirmation")
public class UserConfirmationController {
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String processUserActivation(WebRequest request, Map model) {

		String token = request.getParameter("token");
		
		System.out.println("Token :: "+token);
		
		int random = Integer.parseInt(token);
		userService.activateUser(random);
		
		return "userconfirm";
	}	
	
	

}
