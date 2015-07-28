package com.infosys.internal.cde.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.infosys.internal.cde.model.Language;
import com.infosys.internal.cde.model.QuestionOptions;
import com.infosys.internal.cde.model.Questions;
import com.infosys.internal.cde.service.LanguageService;
import com.infosys.internal.cde.service.QuestionOptionsService;
import com.infosys.internal.cde.service.QuestionsService;
import com.infosys.internal.cde.validators.QuestionPaperCommand;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/admin/questionlist")
public class QuestionListController {
	@Autowired
	private QuestionsService questionsService;
	@Autowired
	private QuestionOptionsService questionOptionsService;
	@Autowired
	private LanguageService languageService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showQuestionList(Map model, HttpServletRequest request,
			HttpSession session) {
		if ((session.getAttribute("adminEmail")) == null) {
			return new ModelAndView("redirect:adminlogin.html");
		}
		List allQuestionList = new ArrayList();
		List questionlist = new ArrayList();

		String languageIdInString = request.getParameter("languageId");
		if (languageIdInString != null && (!languageIdInString.equals(""))) {
			questionlist = questionsService.getQuestionsByLanguageId(Long
					.parseLong(languageIdInString));
			model.put("languageId", Long.parseLong(languageIdInString));
		} else {
			questionlist = questionsService.listQuestions();
		}

		for (int i = 0; i < questionlist.size(); i++) {
			QuestionPaperCommand questionPaperCommand = new QuestionPaperCommand();
			List questionOptionsList = new ArrayList();
			Questions questions = new Questions();
			questions = (Questions) questionlist.get(i);
			questionPaperCommand.setQuestionId(questions.getQuestionId());
			questionPaperCommand.setQuestion(questions.getQuestion());

			List languagelist = languageService
					.getLanguageByLanguageId(questions.getLanguageId());
			if (languagelist != null && languagelist.size() > 0) {
				Language language = (Language) languagelist.get(0);
				questionPaperCommand
						.setLanguageName(language.getLanguageName());
			}

			questionOptionsList = questionOptionsService
					.getQuestionOptionsByQuestionId(questions.getQuestionId());

			if (questionOptionsList != null && questionOptionsList.size() > 0) {
				QuestionOptions questionOptions1 = (QuestionOptions) questionOptionsList
						.get(0);
				QuestionOptions questionOptions2 = (QuestionOptions) questionOptionsList
						.get(1);
				QuestionOptions questionOptions3 = (QuestionOptions) questionOptionsList
						.get(2);
				QuestionOptions questionOptions4 = (QuestionOptions) questionOptionsList
						.get(3);
				if (questionOptions1 != null) {
					questionPaperCommand.setOption1Id(questionOptions1
							.getQuesOpId());
					questionPaperCommand.setOption1(questionOptions1
							.getAnsDescription());
					if (((questionOptions1.getQuesOpId()).compareTo(questions
							.getRightOption())) == 0) {
						questionPaperCommand.setRightAnswer(questionOptions1
								.getAnsDescription());
					}
				}
				if (questionOptions2 != null) {
					questionPaperCommand.setOption2Id(questionOptions2
							.getQuesOpId());
					questionPaperCommand.setOption2(questionOptions2
							.getAnsDescription());
					if (((questionOptions2.getQuesOpId()).compareTo(questions
							.getRightOption())) == 0) {
						questionPaperCommand.setRightAnswer(questionOptions2
								.getAnsDescription());
					}
				}
				if (questionOptions3 != null) {
					questionPaperCommand.setOption3Id(questionOptions3
							.getQuesOpId());
					questionPaperCommand.setOption3(questionOptions3
							.getAnsDescription());
					if (((questionOptions3.getQuesOpId()).compareTo(questions
							.getRightOption())) == 0) {
						questionPaperCommand.setRightAnswer(questionOptions3
								.getAnsDescription());
					}
				}
				if (questionOptions4 != null) {
					questionPaperCommand.setOption4Id(questionOptions4
							.getQuesOpId());
					questionPaperCommand.setOption4(questionOptions4
							.getAnsDescription());
					if (((questionOptions4.getQuesOpId()).compareTo(questions
							.getRightOption())) == 0) {
						questionPaperCommand.setRightAnswer(questionOptions4
								.getAnsDescription());
					}
				}
				questionPaperCommand.setRightOption(questions.getRightOption());
			}
			allQuestionList.add(questionPaperCommand);
		}
		model.put("allQuestionList", allQuestionList);
		return new ModelAndView("admin/questionlist");
	}
}
