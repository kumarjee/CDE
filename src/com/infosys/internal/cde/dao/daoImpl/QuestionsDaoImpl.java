package com.infosys.internal.cde.dao.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infosys.internal.cde.dao.QuestionsDao;
import com.infosys.internal.cde.model.Questions;
import com.infosys.internal.cde.model.Results;

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
	public List<Questions> getQuestionsByCertificationId(Long certificationId) {
		return sessionFactory
				.getCurrentSession()
				.createQuery(
						"from Questions where certificationId=:certificationId ORDER BY questionId DESC")
				.setParameter("certificationId", certificationId).list();
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
						"UPDATE Questions SET certificationId=:certificationId ,question=:question , rightOption=:rightOption where questionId=:questionId")
				.setParameter("certificationId", questions.getCertificationId())
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
	public List<Questions> getTenRandomQuestionsByCertificationId(Long certificationId) {
		return (List<Questions>) sessionFactory
				.getCurrentSession()
				.createQuery(
						"from Questions where certificationId=:certificationId order by rand()")
				.setParameter("certificationId", certificationId).setMaxResults(10)
				.list();
	}

	@Override
	public void uploadQuestions(List<Questions> questions) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void saveResultForUSer(Results results) {
		sessionFactory.getCurrentSession().save(results);
	}
}
