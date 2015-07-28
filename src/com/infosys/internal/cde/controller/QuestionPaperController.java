package com.infosys.internal.cde.controller;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.infosys.internal.cde.model.Admin;
import com.infosys.internal.cde.model.QuestionOptions;
import com.infosys.internal.cde.model.Questions;
import com.infosys.internal.cde.model.User;
import com.infosys.internal.cde.service.QuestionOptionsService;
import com.infosys.internal.cde.service.QuestionsService;
import com.infosys.internal.cde.validators.QuestionPaperCommand;

@Controller
@RequestMapping("/user/questionpaper")
public class QuestionPaperController {
	@Autowired
	private QuestionsService questionsService;
	@Autowired
	private QuestionOptionsService questionOptionsService;

	@RequestMapping(method = RequestMethod.GET)
	public String showQuestionPaper(HttpServletRequest request, Map model,
			HttpSession session) {
		if ((session.getAttribute("userEmail")) == null) {
			User user = new User();
			model.put("user", user);
			return "/user/userlogin";
		}
		List questionPaperList = new ArrayList();
		List questonIdList = new ArrayList();
		String languageIdInString = request.getParameter("languageId");
		if (languageIdInString != null) {
			Long languageId = Long.parseLong(languageIdInString);
			QuestionPaperCommand questionPaperCommand1 = new QuestionPaperCommand();
			// List
			// questionlist=questionsService.getQuestionsByLanguageId(languageId);
			List questionlist = questionsService
					.getTenRandomQuestionsByLanguageId(languageId);

			for (int i = 0; i < questionlist.size(); i++) {
				List questionOptionsList = new ArrayList();
				QuestionPaperCommand questionPaperCommand = new QuestionPaperCommand();
				Questions questions = new Questions();
				questions = (Questions) questionlist.get(i);

				// set questonId in questonIdList
				questonIdList.add(i, questions.getQuestionId());
				questionPaperCommand.setQuestionId(questions.getQuestionId());
				questionPaperCommand.setQuestion(questions.getQuestion());

				questionOptionsList = questionOptionsService
						.getQuestionOptionsByQuestionId(questions
								.getQuestionId());
				if (questionOptionsList != null
						&& questionOptionsList.size() > 0) {
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
					}
					if (questionOptions2 != null) {
						questionPaperCommand.setOption2Id(questionOptions2
								.getQuesOpId());
						questionPaperCommand.setOption2(questionOptions2
								.getAnsDescription());
					}
					if (questionOptions3 != null) {
						questionPaperCommand.setOption3Id(questionOptions3
								.getQuesOpId());
						questionPaperCommand.setOption3(questionOptions3
								.getAnsDescription());
					}
					if (questionOptions4 != null) {
						questionPaperCommand.setOption4Id(questionOptions4
								.getQuesOpId());
						questionPaperCommand.setOption4(questionOptions4
								.getAnsDescription());
					}
				}
				questionPaperList.add(questionPaperCommand);
			}
		}
		session.setAttribute("questonIdList", questonIdList);
		model.put("questionPaperList", questionPaperList);
		return "/user/questionpaper";
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView processQuestionPaper(Map model,
			HttpServletRequest request, HttpSession session) {
		String[] question = request.getParameterValues("question");
		int rightAnswer = 0;
		for (int i = 0; i < question.length; i++) {
			if (request.getParameter("quesNum[" + i + "]") != null
					&& request.getParameter("option[" + i + "]") != null) {
				List<Questions> questionlist = new ArrayList<Questions>();
				Long questionId = Long.parseLong(request
						.getParameter("quesNum[" + i + "]"));
				Long rightOption = Long.parseLong(request
						.getParameter("option[" + i + "]"));
				questionlist = questionsService
						.getQuestionsByQuestionId(questionId);
				if (questionlist != null && questionlist.size() > 0) {
					Questions questions = new Questions();
					questions = questionlist.get(0);
					int comp = rightOption
							.compareTo(questions.getRightOption());
					if (comp == 0) {
						rightAnswer++;
					}
				}
			}
		}
		session.setAttribute("totalQuestion", question.length);
		session.setAttribute("rightAnswer", rightAnswer);
		session.setAttribute("wongAnswer", (question.length) - rightAnswer);

		return new ModelAndView("redirect:questionpaperresult.html");
	}
}
