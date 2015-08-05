package com.infosys.internal.cde.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.infosys.internal.cde.validators.AddQuestionForm;

@Component("addCertificationValidator")
public class AddCertificationValidator{
	   public boolean supports(Class<?> klass){
		      return AddCertificationForm.class.isAssignableFrom(klass);
		 }
	   
	   public void validate(Object target, Errors errors){
		      AddCertificationForm addValidationForm = (AddCertificationForm) target;
		      if(addValidationForm.getBusinessLine()==null || addValidationForm.getBusinessLine().length()==0){
		    	  errors.rejectValue("businessLine","Business line cannot be empty");
		       }
		      if(addValidationForm.getCertificationName()==null || addValidationForm.getCertificationName().length()==0){
		    	  errors.rejectValue("certificationName","NotEmpty.addCertificationForm.certificationName","Enter certification Name.");
		       }
		      if(addValidationForm.getExamPattern()==null || addValidationForm.getExamPattern().length()==0){
		    	  errors.rejectValue("examPattern","NotEmpty.addCertificationForm.examPattern","Select an exam pattern.");
		       }
	   }
  }
