package com.infosys.internal.cde.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.infosys.internal.cde.model.Admin;
import com.infosys.internal.cde.model.Questions;
import com.infosys.internal.cde.service.LanguageService;
import com.infosys.internal.cde.service.QuestionOptionsService;
import com.infosys.internal.cde.service.QuestionsService;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/admin/deletequestion")
public class DeleteQuestionController {
	@Autowired
	private LanguageService languageService;
	@Autowired
	private QuestionsService questionsService;
	@Autowired
	private QuestionOptionsService questionOptionsService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showDeleteQuestion(Map model,
			HttpServletRequest request, HttpSession session) {
		if ((session.getAttribute("adminEmail")) == null) {
			// Admin admin=new Admin();
			// model.put("admin",admin);
			// return "/admin/adminlogin";
			return new ModelAndView("redirect:adminlogin.html");
		}
		model.put("languagelist", languageService.listLanguages());
		String questionIdInString = request.getParameter("questionId");
		if (questionIdInString != null && (!questionIdInString.equals(""))) {
			Questions questions = new Questions();
			questions.setQuestionId(Long.parseLong(questionIdInString));
			questionsService.deleteQuestions(questions);
			questionOptionsService.deleteQuestionOptionsByQuestionId(Long
					.parseLong(questionIdInString));
		}
		return new ModelAndView("redirect:questionlist.html?languageId="
				+ request.getParameter("languageId"));
	}
}
