package com.infosys.internal.cde.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import com.infosys.internal.cde.model.QuestionOptions;
import com.infosys.internal.cde.model.Questions;
import com.infosys.internal.cde.model.Results;
import com.infosys.internal.cde.model.User;
import com.infosys.internal.cde.service.QuestionOptionsService;
import com.infosys.internal.cde.service.QuestionsService;
import com.infosys.internal.cde.validators.QuestionPaperCommand;

import java.util.Map;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/user/questionpaperresult")
public class QuestionPaperResultController {

	@Autowired
	private QuestionsService questionsService;
	@Autowired
	private QuestionOptionsService questionOptionsService;

	@RequestMapping(method = RequestMethod.GET)
	public String showQuestionPaperResult(Map model, HttpSession session,WebRequest request) {
		if ((session.getAttribute("userEmail")) == null) {
			User user = new User();
			model.put("user", user);
			return "/user/userlogin";
		}
		String certificationIdString = (String) session.getAttribute("certificationId");
		System.out.println("certificationId in result controller :: "+certificationIdString);
		List<QuestionPaperCommand> questionPaperList = new ArrayList<QuestionPaperCommand>();
		List questonIdList = (List) session.getAttribute("questonIdList");

		List questionlist = new ArrayList();
		Results results = new Results();
		for (int i = 0; i < questonIdList.size(); i++) {
			Long questionId = (Long) questonIdList.get(i);
			questionlist = questionsService
					.getQuestionsByQuestionId(questionId);
			if (questionlist != null && questionlist.size() > 0) {
				for (int j = 0; j < questionlist.size(); j++) {
					QuestionPaperCommand questionPaperCommand = new QuestionPaperCommand();
					List questionOptionsList = new ArrayList();
					Questions questions = new Questions();
					questions = (Questions) questionlist.get(j);
					questionPaperCommand.setQuestionId(questions
							.getQuestionId());
					questionPaperCommand.setQuestion(questions.getQuestion());
					// questionOptionsList
					questionOptionsList = questionOptionsService
							.getQuestionOptionsByQuesOpId(questions
									.getRightOption());
					if (questionOptionsList != null
							&& questionOptionsList.size() > 0) {
						QuestionOptions questionOptions = (QuestionOptions) questionOptionsList
								.get(0);
						questionPaperCommand.setOption1(questionOptions
								.getAnsDescription());

					}
					questionPaperList.add(questionPaperCommand);
				}
			}
		}

		int noOfRightAnswers = (Integer)session.getAttribute("rightAnswer");
		String user = (String) session.getAttribute("userEmail");
		int totalQuestion = (Integer)session.getAttribute("totalQuestion");
		Long resultPercentage = (long) (noOfRightAnswers*100/totalQuestion);
		String result = resultPercentage>35.0?"Pass":"Fail";
		//String certificationIdinString = (String)session.getAttribute("certificationId");
		Long certificationId =  Long.parseLong(certificationIdString);
		results.setExamDate(new java.sql.Timestamp(new java.util.Date().getTime()));
		results.setResult(result);
		results.setLanguageId(certificationId);
		results.setUser(user);
		results.setScore(resultPercentage);
		questionsService.saveResultForUSer(results);
		
		model.put("questionPaperList", questionPaperList);
		model.put("totalQuestion", totalQuestion);
		model.put("rightAnswer", noOfRightAnswers);
		model.put("wongAnswer", session.getAttribute("wongAnswer"));

		session.removeAttribute("totalQuestion");
		session.removeAttribute("rightAnswer");
		session.removeAttribute("wongAnswer");

		return "/user/questionpaperresult";
	}

}
