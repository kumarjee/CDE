package com.infosys.internal.cde.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.infosys.internal.cde.model.Admin;
import com.infosys.internal.cde.model.Certification;
import com.infosys.internal.cde.service.CertificationService;

import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping(value="/admin/searchquestion")
public class SearchQuestionController {
	@Autowired
	private CertificationService certificationService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String showSearchQuestion(Map model,HttpSession session){
		   if((session.getAttribute("adminEmail"))==null){
			   Admin admin=new Admin();
			   model.put("admin",admin);
			   return "/admin/adminlogin";
			 }
		   Certification certification=new Certification();
		   model.put("certification", certification);
		   model.put("certificationlist", certificationService.listCertifications());
		   return "/admin/searchquestion";
	 }
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView processSearchQuestion(@Valid Certification certification,Map model){
		   Long certificationId=certification.getCertificationId();
		   if(certificationId==-1){
			  model.put("certificationlist", certificationService.listCertifications());
			  model.put("errormessage", "Select Certification");
			  return new ModelAndView("admin/searchquestion");
		   }
		   return new ModelAndView("redirect:questionlist.html?certificationId="+certification.getCertificationId());
	 }
 }
