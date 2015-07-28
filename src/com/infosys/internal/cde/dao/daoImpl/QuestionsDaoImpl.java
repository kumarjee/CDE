package com.infosys.internal.cde.dao.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infosys.internal.cde.dao.QuestionsDao;
import com.infosys.internal.cde.model.Questions;

@Repository("questionsDao")
public class QuestionsDaoImpl implements QuestionsDao {
	@Autowired
	private SessionFactory sessionFactory;

	public List<Questions> listQuestions() {
		return (List<Questions>) sessionFactory.getCurrentSession()
				.createCriteria(Questions.class).addOrder(
						Order.desc("questionId")).list();
	}

	@Override
	public List<Questions> getQuestionsByLanguageId(Long languageId) {
		return sessionFactory
				.getCurrentSession()
				.createQuery(
						"from Questions where languageId=:languageId ORDER BY questionId DESC")
				.setParameter("languageId", languageId).list();
	}

	@Override
	public List<Questions> getQuestionsByQuestionId(Long questionId) {
		return sessionFactory
				.getCurrentSession()
				.createQuery(
						"from Questions where questionId=:questionId ORDER BY questionId DESC")
				.setParameter("questionId", questionId).list();
	}

	public void saveQuestions(Questions questions) {
		sessionFactory.getCurrentSession().save(questions);
	}

	@Override
	public void updateQuestions(Questions questions) {
		sessionFactory
				.getCurrentSession()
				.createQuery(
						"UPDATE Questions SET languageId=:languageId ,question=:question , rightOption=:rightOption where questionId=:questionId")
				.setParameter("languageId", questions.getLanguageId())
				.setParameter("question", questions.getQuestion())
				.setParameter("rightOption", questions.getRightOption())
				.setParameter("questionId", questions.getQuestionId())
				.executeUpdate();
	}

	@Override
	public void deleteQuestions(Questions questions) {
		sessionFactory.getCurrentSession().createQuery(
				"delete from Questions where questionId=:questionId")
				.setParameter("questionId", questions.getQuestionId())
				.executeUpdate();
	}

	@Override
	public List<Questions> getTenRandomQuestionsByLanguageId(Long languageId) {
		return (List<Questions>) sessionFactory
				.getCurrentSession()
				.createQuery(
						"from Questions where languageId=:languageId order by rand()")
				.setParameter("languageId", languageId).setMaxResults(10)
				.list();
	}

	@Override
	public void uploadQuestions(List<Questions> questions) {
		// TODO Auto-generated method stub
		
	}
}
