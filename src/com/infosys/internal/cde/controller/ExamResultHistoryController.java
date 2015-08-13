package com.infosys.internal.cde.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.infosys.internal.cde.model.Results;
import com.infosys.internal.cde.service.UserService;


@Controller
@RequestMapping(value="/user/UserResultHistory")
public class ExamResultHistoryController {

	@Autowired
	UserService userService;

	@RequestMapping(method =RequestMethod.GET)
	public String showResultHistory(Map model, HttpSession session){
		System.out.println("In Result History Controller");
		String user = (String) session.getAttribute("userEmail");
		if ((session.getAttribute("userEmail")) == null) {
			return "/user/userlogin";
		}
		System.out.println("User logined :: "+user);
		List<Results> resultList =userService.getExamHistoryOfUser(user);

		if(resultList != null){
			List<Results> results =new ArrayList<Results>();

			for (Results result : resultList) {
				results.add(result);
			}

			model.put("results", results);
		}
		return "/user/UserResultHistory";

	}

}
