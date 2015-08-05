package com.infosys.internal.cde.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.infosys.internal.cde.dao.QuestionsDao;
import com.infosys.internal.cde.model.Questions;
import com.infosys.internal.cde.service.QuestionsService;

@Service("questionsService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class QuestionsServiceImpl implements QuestionsService {
   
	@Autowired
	private QuestionsDao questionsDao;
	
	@Override
	public List<Questions> listQuestions(){
		   return questionsDao.listQuestions();		
	 }
	
	@Override
	public List<Questions> getQuestionsByCertificationId(Long certificationId){
		   return questionsDao.getQuestionsByCertificationId(certificationId);		
	  }
	
	@Override
	public List<Questions> getQuestionsByQuestionId(Long questionId){
		   return questionsDao.getQuestionsByQuestionId(questionId);
	    }
	
	@Override
	public void saveQuestions(Questions questions){
		   questionsDao.saveQuestions(questions);
	 }
	
	@Override
	public void updateQuestions(Questions questions){
		   questionsDao.updateQuestions(questions);
	 }
	
	@Override
	public void deleteQuestions(Questions questions){
		questionsDao.deleteQuestions(questions); 
	 }
	
	@Override
	public List<Questions> getTenRandomQuestionsByCertificationId(Long certificationId){
		return questionsDao.getTenRandomQuestionsByCertificationId(certificationId);  
	 }

	@Override
	public void uploadQuestions(List<Questions> questions) {
		// TODO Auto-generated method stub
		
	}
}
