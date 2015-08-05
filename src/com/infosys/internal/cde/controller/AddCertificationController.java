package com.infosys.internal.cde.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.infosys.internal.cde.model.Admin;
import com.infosys.internal.cde.service.CertificationService;
import com.infosys.internal.cde.service.QuestionOptionsService;
import com.infosys.internal.cde.service.QuestionsService;
import com.infosys.internal.cde.validators.AddCertificationForm;
import com.infosys.internal.cde.validators.AddCertificationValidator;

@Controller
@RequestMapping("/admin/addCertification")
public class AddCertificationController {

	@Autowired
	private CertificationService certificationService;
    @Autowired
	private AddCertificationValidator addCertificationValidator;
	@Autowired
	private QuestionsService questionsService;
	@Autowired
	private QuestionOptionsService questionOptionsService;

	@RequestMapping(method = RequestMethod.GET)
	public String showAddCertificationController(Map model, HttpServletRequest request,
			HttpSession session) {
		if ((session.getAttribute("adminEmail")) == null) {
			Admin admin = new Admin();
			model.put("admin", admin);
			return "/admin/adminlogin";
		}
		AddCertificationForm certificationForm = new AddCertificationForm();
		String pageHeading = "Add Certification";
		//if fined questionId then edit Question
		model.put("pageHeading", pageHeading);
		model.put("certificationForm", certificationForm);
		return "/admin/addCertification";
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView processAddCertificationController(
			@Valid AddCertificationForm addCertification, BindingResult result,
			Map model, HttpSession session) {
		if ((session.getAttribute("adminEmail")) == null) {
			return new ModelAndView("redirect:adminlogin.html");
		}
		addCertificationValidator.validate(addCertification, result);
		String pageHeading = "Add Certification";
		if(result.hasErrors()){
			model.put("pageHeading", pageHeading);
			model.put("certificationForm", addCertification);
			return new ModelAndView("redirect:addCertification.html");
		}
		return null;
		
	}
}
