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
@Table(name = "questions")
public class Questions {

	@Id
	@GeneratedValue
	@Column(name = "ques_id")
	private Long questionId;

	@Column(name = "cert_id")
	private Long certificationId;

	@Column(name = "question")
	private String question;

	@Column(name = "right_option")
	private Long rightOption;

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setCertificationId(Long certificationId) {
		this.certificationId = certificationId;
	}

	public Long getCertificationId() {
		return certificationId;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getQuestion() {
		return question;
	}

	public void setRightOption(Long rightOption) {
		this.rightOption = rightOption;
	}

	public Long getRightOption() {
		return rightOption;
	}
}
