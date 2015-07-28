package com.infosys.internal.cde.service;

import java.util.List;

import com.infosys.internal.cde.model.QuestionOptions;

public interface QuestionOptionsService {
	public List<QuestionOptions> listQuestionOptions();

	public List<QuestionOptions> getQuestionOptionsByQuestionId(Long questionId);

	public List<QuestionOptions> getQuestionOptionsByQuesOpId(Long quesOpId);

	public void saveQuestionOptions(QuestionOptions questionOptions);

	public void updateQuestionOptions(QuestionOptions questionOptions);

	public void deleteQuestionOptionsByQuestionId(Long questionId);
}
