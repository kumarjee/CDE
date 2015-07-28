package com.infosys.internal.cde.dao.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.infosys.internal.cde.dao.QuestionOptionsDao;
import com.infosys.internal.cde.model.QuestionOptions;

@Repository("questionOptionsDao")
public class QuestionOptionsDaoImpl implements QuestionOptionsDao {
	@Autowired
	private SessionFactory sessionFactory;

	public List<QuestionOptions> listQuestionOptions() {
		return sessionFactory.getCurrentSession().createQuery(
				"from QuestionOptions where quesOpId=1").list();
	}

	@Override
	public List<QuestionOptions> getQuestionOptionsByQuestionId(Long questionId) {
		return sessionFactory.getCurrentSession().createQuery(
				"from QuestionOptions where questionId=:questionId")
				.setParameter("questionId", questionId).list();
	}

	@Override
	public List<QuestionOptions> getQuestionOptionsByQuesOpId(Long quesOpId) {
		return sessionFactory.getCurrentSession().createQuery(
				"from QuestionOptions where quesOpId=:quesOpId").setParameter(
				"quesOpId", quesOpId).list();
	}

	@Override
	public void saveQuestionOptions(QuestionOptions questionOptions) {
		sessionFactory.getCurrentSession().saveOrUpdate(questionOptions);
	}

	@Override
	public void updateQuestionOptions(QuestionOptions questionOptions) {
		sessionFactory
				.getCurrentSession()
				.createQuery(
						"UPDATE QuestionOptions  SET ansDescription=:ansDescription ,questionId=:questionId where quesOpId=:quesOpId")
				.setParameter("ansDescription",
						questionOptions.getAnsDescription()).setParameter(
						"questionId", questionOptions.getQuestionId())
				.setParameter("quesOpId", questionOptions.getQuesOpId())
				.executeUpdate();
	}

	@Override
	public void deleteQuestionOptionsByQuestionId(Long questionId) {
		sessionFactory.getCurrentSession().createQuery(
				"delete from  QuestionOptions where questionId=:questionId")
				.setParameter("questionId", questionId).executeUpdate();
	}
}
