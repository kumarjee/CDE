package com.infosys.internal.cde.validators;

import org.hibernate.validator.constraints.NotEmpty;

public class AddQuestionForm {
	   private Long  questionId;
	   private Long certificationId;
	   @NotEmpty
	   private String question;
	   private Long rightOption;
	   @NotEmpty
	   private String option1;
	   @NotEmpty
	   private String option2;
	   @NotEmpty
	   private String option3;
	   @NotEmpty
	   private String option4;
	   
	   public void setQuestionId(Long questionId){
		   this.questionId = questionId;
		}	   
	   public Long getQuestionId(){
		      return questionId;
		 }
	   
	   public void setCertificationId(Long certificationId) {
		      this.certificationId = certificationId;
		 }
	   public Long getCertificationId() {
		      return certificationId;
		}
	   
	   public void setQuestion(String question){
		      this.question = question;
		 }
	   public String getQuestion(){
		      return question;
		 }
	   
	   public void setRightOption(Long rightOption){
		      this.rightOption = rightOption;
		   }
	   public Long getRightOption() {
		      return rightOption;
		   }
	   
	   public void setOption1(String option1){
		      this.option1 = option1;
		 }
	   public String getOption1(){
		      return option1;
		 }
	   public void setOption2(String option2){
		      this.option2 = option2;
		 }
	   public String getOption2(){
		      return option2;
		 }
	   
	   public void setOption3(String option3){
		      this.option3 = option3;
		 }
	   public String getOption3(){
		      return option3;
		 }
	   
	   public void setOption4(String option4){
		      this.option4 = option4;
		 }
	   public String getOption4(){
		      return option4;
		 }	   
 }

