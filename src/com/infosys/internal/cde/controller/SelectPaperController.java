package com.infosys.internal.cde.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.infosys.internal.cde.model.Certification;
import com.infosys.internal.cde.model.User;
import com.infosys.internal.cde.service.CertificationService;

import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/user/selectpaper")
public class SelectPaperController {
	@Autowired
	private CertificationService certificationService;

	@RequestMapping(method = RequestMethod.GET)
	public String showSelectPaper(Map model, HttpSession session) {
		if ((session.getAttribute("userEmail")) == null) {
			User user = new User();
			model.put("user", user);
			return "/user/userlogin";
		}
		Certification certification = new Certification();
		model.put("certification", certification);
		model.put("certificationlist", certificationService.listCertifications());
		return "/user/selectpaper";
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView processSelectPaper(@Valid Certification certification, Map model,
			HttpSession session) {
		if ((session.getAttribute("userEmail")) == null) {
			return new ModelAndView("redirect:userlogin.html");
		}
		Long certificationId = certification.getCertificationId();
		System.out.println("certificationId in select paper control :: "+certificationId);
		if (certificationId == -1) {
			model.put("certificationlist", certificationService.listCertifications());
			model.put("errormessage", "Select certification");
			return new ModelAndView("/user/selectpaper");
		}
		return new ModelAndView("redirect:questionpaper.html?certificationId="
				+ certification.getCertificationId());
	}
}
