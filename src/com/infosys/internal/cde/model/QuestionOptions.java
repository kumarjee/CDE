package com.infosys.internal.cde.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
@SuppressWarnings("serial")
@Table(name = "question_options")
public class QuestionOptions {

	@Id
	@GeneratedValue
	@Column(name = "ques_op_id")
	private Long quesOpId;

	@Column(name = "ans_description")
	private String ansDescription;

	@Column(name = "ques_id")
	private Long questionId;

	public void setQuesOpId(Long quesOpId) {
		this.quesOpId = quesOpId;
	}

	public Long getQuesOpId() {
		return quesOpId;
	}

	public void setAnsDescription(String ansDescription) {
		this.ansDescription = ansDescription;
	}

	public String getAnsDescription() {
		return ansDescription;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public Long getQuestionId() {
		return questionId;
	}
}
