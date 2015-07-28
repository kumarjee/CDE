package com.infosys.internal.cde.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.infosys.internal.cde.model.User;

@Controller
@RequestMapping("/index")
public class IndexController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showIndex(Map model, HttpSession session) {		
			return new ModelAndView("/index");
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView processUserLogin(@Valid User user,
			BindingResult result, Map model, HttpSession session) {
		return new ModelAndView("/index");
	}
}
