package com.infosys.internal.cde.dao;

import java.util.List;

import com.infosys.internal.cde.model.Questions;
import com.infosys.internal.cde.model.User;

public interface QuestionsDao {
	public List<Questions> listQuestions();

	public List<Questions> getQuestionsByLanguageId(Long languageId);

	public List<Questions> getQuestionsByQuestionId(Long questionId);

	public void saveQuestions(Questions questions);

	public void updateQuestions(Questions questions);

	public void deleteQuestions(Questions questions);

	public List<Questions> getTenRandomQuestionsByLanguageId(Long languageId);
	
	public void uploadQuestions(List<Questions> questions);
}
