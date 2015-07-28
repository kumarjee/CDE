package com.infosys.internal.cde.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.infosys.internal.cde.model.Admin;
import com.infosys.internal.cde.model.QuestionOptions;
import com.infosys.internal.cde.model.Questions;
import com.infosys.internal.cde.service.LanguageService;
import com.infosys.internal.cde.service.QuestionOptionsService;
import com.infosys.internal.cde.service.QuestionsService;
import com.infosys.internal.cde.validators.AddQuestionForm;
import com.infosys.internal.cde.validators.AddQuestionValidator;

import java.util.Map;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/admin/addquestion")
public class AddQuestionController {

	@Autowired
	private LanguageService languageService;
    @Autowired
	private AddQuestionValidator addQuestionValidator;
	@Autowired
	private QuestionsService questionsService;
	@Autowired
	private QuestionOptionsService questionOptionsService;

	@RequestMapping(method = RequestMethod.GET)
	public String showQuestionController(Map model, HttpServletRequest request,
			HttpSession session) {
		if ((session.getAttribute("adminEmail")) == null) {
			Admin admin = new Admin();
			model.put("admin", admin);
			return "/admin/adminlogin";
		}
		AddQuestionForm addQuestionForm = new AddQuestionForm();
		String pageHeading = "Add Question";
		// if fined questionId then edit Question
		if (request.getParameter("questionId") != null) {
			pageHeading = "Edit Question";
			Long questionId = Long
					.parseLong(request.getParameter("questionId"));
			List questionlist = questionsService
					.getQuestionsByQuestionId(questionId);
			if (questionlist != null && questionlist.size() > 0) {
				Questions questions = (Questions) questionlist.get(0);
				addQuestionForm.setQuestionId(questions.getQuestionId());
				addQuestionForm.setLanguageId(questions.getLanguageId());
				addQuestionForm.setQuestion(questions.getQuestion());

				List questionoptionslist = questionOptionsService
						.getQuestionOptionsByQuestionId(questionId);
				if (questionoptionslist != null
						&& questionoptionslist.size() > 0) {
					QuestionOptions questionOptions1 = (QuestionOptions) questionoptionslist
							.get(0);
					QuestionOptions questionOptions2 = (QuestionOptions) questionoptionslist
							.get(1);
					QuestionOptions questionOptions3 = (QuestionOptions) questionoptionslist
							.get(2);
					QuestionOptions questionOptions4 = (QuestionOptions) questionoptionslist
							.get(3);

					addQuestionForm.setOption1(questionOptions1
							.getAnsDescription());
					addQuestionForm.setOption2(questionOptions2
							.getAnsDescription());
					addQuestionForm.setOption3(questionOptions3
							.getAnsDescription());
					addQuestionForm.setOption4(questionOptions4
							.getAnsDescription());

					if ((questionOptions1.getQuesOpId()).compareTo(questions
							.getRightOption()) == 0) {
						addQuestionForm.setRightOption(new Long(1));
					}
					if ((questionOptions2.getQuesOpId()).compareTo(questions
							.getRightOption()) == 0) {
						addQuestionForm.setRightOption(new Long(2));
					}
					if ((questionOptions3.getQuesOpId()).compareTo(questions
							.getRightOption()) == 0) {
						addQuestionForm.setRightOption(new Long(3));
					}
					if ((questionOptions4.getQuesOpId()).compareTo(questions
							.getRightOption()) == 0) {
						addQuestionForm.setRightOption(new Long(4));
					}
				}
			}
		}
		model.put("pageHeading", pageHeading);
		model.put("addQuestionForm", addQuestionForm);
		model.put("languagelist", languageService.listLanguages());
		return "/admin/addquestion";
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView processQuestionController(
			@Valid AddQuestionForm addQuestionForm, BindingResult result,
			Map model, HttpSession session) {
		if ((session.getAttribute("adminEmail")) == null) {
			return new ModelAndView("redirect:adminlogin.html");
		}
		addQuestionValidator.validate(addQuestionForm, result);
		String pageHeading = "Add Question";
		if (addQuestionForm.getQuestionId() != null)
			pageHeading = "Edit Question";
		// check all error
		if (result.hasErrors()) {
			model.put("pageHeading", pageHeading);
			model.put("languagelist", languageService.listLanguages());
			ModelAndView modelandview = new ModelAndView();
			return new ModelAndView("/admin/addquestion");
		} else {
			Questions questions = new Questions();
			questions.setLanguageId(addQuestionForm.getLanguageId());
			questions.setQuestion(addQuestionForm.getQuestion());
			// Add Question and Answer
			if (addQuestionForm.getQuestionId() == null) {
				questions.setRightOption(new Long(0));
				questionsService.saveQuestions(questions);

				QuestionOptions questionOptions1 = new QuestionOptions();
				questionOptions1
						.setAnsDescription(addQuestionForm.getOption1());
				questionOptions1.setQuestionId(questions.getQuestionId());
				questionOptionsService.saveQuestionOptions(questionOptions1);

				QuestionOptions questionOptions2 = new QuestionOptions();
				questionOptions2
						.setAnsDescription(addQuestionForm.getOption2());
				questionOptions2.setQuestionId(questions.getQuestionId());
				questionOptionsService.saveQuestionOptions(questionOptions2);

				QuestionOptions questionOptions3 = new QuestionOptions();
				questionOptions3
						.setAnsDescription(addQuestionForm.getOption3());
				questionOptions3.setQuestionId(questions.getQuestionId());
				questionOptionsService.saveQuestionOptions(questionOptions3);

				QuestionOptions questionOptions4 = new QuestionOptions();
				questionOptions4
						.setAnsDescription(addQuestionForm.getOption4());
				questionOptions4.setQuestionId(questions.getQuestionId());
				questionOptionsService.saveQuestionOptions(questionOptions4);

				int comp1 = 1;
				int comp2 = 1;
				int comp3 = 1;
				int comp4 = 1;
				comp1 = (addQuestionForm.getRightOption())
						.compareTo(new Long(1));
				comp2 = (addQuestionForm.getRightOption())
						.compareTo(new Long(2));
				comp3 = (addQuestionForm.getRightOption())
						.compareTo(new Long(3));
				comp4 = (addQuestionForm.getRightOption())
						.compareTo(new Long(4));

				if (comp1 == 0) {
					questions.setRightOption(questionOptions1.getQuesOpId());
					questionsService.updateQuestions(questions);
				}
				if (comp2 == 0) {
					questions.setRightOption(questionOptions2.getQuesOpId());
					questionsService.updateQuestions(questions);
				}
				if (comp3 == 0) {
					questions.setRightOption(questionOptions3.getQuesOpId());
					questionsService.updateQuestions(questions);
				}
				if (comp4 == 0) {
					questions.setRightOption(questionOptions4.getQuesOpId());
					questionsService.updateQuestions(questions);
				}
			} else {
				// update Question and Answer
				questions.setQuestionId(addQuestionForm.getQuestionId());

				List questionoptionslist = questionOptionsService
						.getQuestionOptionsByQuestionId(addQuestionForm
								.getQuestionId());
				if (questionoptionslist != null
						&& questionoptionslist.size() > 0) {
					QuestionOptions questionOptions1 = (QuestionOptions) questionoptionslist
							.get(0);
					QuestionOptions questionOptions2 = (QuestionOptions) questionoptionslist
							.get(1);
					QuestionOptions questionOptions3 = (QuestionOptions) questionoptionslist
							.get(2);
					QuestionOptions questionOptions4 = (QuestionOptions) questionoptionslist
							.get(3);

					questionOptions1.setAnsDescription(addQuestionForm
							.getOption1());
					questionOptions2.setAnsDescription(addQuestionForm
							.getOption2());
					questionOptions3.setAnsDescription(addQuestionForm
							.getOption3());
					questionOptions4.setAnsDescription(addQuestionForm
							.getOption4());

					questionOptionsService
							.updateQuestionOptions(questionOptions1);
					questionOptionsService
							.updateQuestionOptions(questionOptions2);
					questionOptionsService
							.updateQuestionOptions(questionOptions3);
					questionOptionsService
							.updateQuestionOptions(questionOptions4);

					if ((addQuestionForm.getRightOption())
							.compareTo(new Long(1)) == 0) {
						questions
								.setRightOption(questionOptions1.getQuesOpId());
					}
					if ((addQuestionForm.getRightOption())
							.compareTo(new Long(2)) == 0) {
						questions
								.setRightOption(questionOptions2.getQuesOpId());
					}
					if ((addQuestionForm.getRightOption())
							.compareTo(new Long(3)) == 0) {
						questions
								.setRightOption(questionOptions3.getQuesOpId());
					}
					if ((addQuestionForm.getRightOption())
							.compareTo(new Long(4)) == 0) {
						questions
								.setRightOption(questionOptions4.getQuesOpId());
					}

					questionsService.updateQuestions(questions);
				}
			}

		}
		return new ModelAndView("redirect:questionlist.html");
	}
}
