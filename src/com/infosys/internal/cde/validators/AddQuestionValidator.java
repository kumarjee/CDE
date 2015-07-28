package com.infosys.internal.cde.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.infosys.internal.cde.validators.AddQuestionForm;

@Component("addQuestionValidator")
public class AddQuestionValidator{
	   public boolean supports(Class<?> klass){
		      return AddQuestionForm.class.isAssignableFrom(klass);
		 }
	   
	   public void validate(Object target, Errors errors){
		      AddQuestionForm addQuestionForm = (AddQuestionForm) target;
		      if(addQuestionForm.getLanguageId()==-1){
		    	  errors.rejectValue("languageId","NotEmpty.addQuestionForm.languageId","Select Language.");
		       }
		      if(addQuestionForm.getRightOption()==null){
		    	  errors.rejectValue("rightOption","selectRightAnswer.addQuestionForm.rightOption","Select Right Answer.");
		       }
	   }
  }
