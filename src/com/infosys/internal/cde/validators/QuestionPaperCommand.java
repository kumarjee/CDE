package com.infosys.internal.cde.validators;

public class QuestionPaperCommand {
	private Long questionId;
	private String certificationName;
	private String question;
	private Long option1Id;
	private String option1;
	private Long option2Id;
	private String option2;
	private Long option3Id; 
	private String option3;
	private Long option4Id;
	private String option4;
	private Long rightOption;
	private String rightAnswer;
	
    public void setQuestionId(Long questionId){
		   this.questionId = questionId;
	  }
	public Long getQuestionId() {
		   return questionId;
	  }	
	
	public void setCertificationName(String certificationName){
		   this.certificationName = certificationName;
     }
	public String getCertificationName(){
		   return certificationName;
     }
	
	public void setQuestion(String question){
		   this.question = question;
     }
	public String getQuestion(){
		   return question;
     }
	
	public void setOption1Id(Long option1Id){
		   this.option1Id = option1Id;
	  }
	public Long getOption1Id() {
		   return option1Id;
	  }	
	
	public void setOption1(String option1){
		   this.option1 = option1;
      }
	public String getOption1(){
		   return option1;
      }
	
	public void setOption2Id(Long option2Id){
		   this.option2Id = option2Id;
	  }
	public Long getOption2Id() {
		   return option2Id;
	  }	
	
	public void setOption2(String option2){
		   this.option2 = option2;
      }
	public String getOption2(){
		   return option2;
      }
	
	public void setOption3Id(Long option3Id){
		   this.option3Id = option3Id;
	  }
	public Long getOption3Id() {
		   return option3Id;
	  }
	
	public void setOption3(String option3){
		   this.option3 = option3;
     }
	public String getOption3(){
		   return option3;
      }
	
	public void setOption4Id(Long option4Id){
		   this.option4Id = option4Id;
	  }
	public Long getOption4Id() {
		   return option4Id;
	  }
	
	public void setOption4(String option4){
		   this.option4 = option4;
     }
	public String getOption4(){
		   return option4;
      }
	
	public void setRightOption(Long rightOption){
		   this.rightOption = rightOption;
     }
	public Long getRightOption(){
		   return rightOption;
     }
   
	public void setRightAnswer(String rightAnswer){
		   this.rightAnswer = rightAnswer;
     }
	public String getRightAnswer(){
		   return rightAnswer;
     } 
}
