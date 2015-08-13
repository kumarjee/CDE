package com.infosys.internal.cde.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
@SuppressWarnings("serial")
@Table(name = "results")
public class Results {

	@Id
	@GeneratedValue
	@Column(name = "result_id")
	private Long resultId;

	public Long getResultId() {
		return resultId;
	}

	public void setResultId(Long resultId) {
		this.resultId = resultId;
	}

	public Long getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Long languageId) {
		this.languageId = languageId;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Long getScore() {
		return score;
	}

	public void setScore(Long score) {
		this.score = score;
	}

	@Column(name = "lang_id")
	private Long languageId;

	@Column(name = "result")
	private String result;

	@Column(name = "score")
	private Long score;
	
	@Column(name = "exam_date")
	private Timestamp examDate;
	
	public Timestamp getExamDate() {
		return examDate;
	}

	public void setExamDate(Timestamp examDate) {
		this.examDate = examDate;
	}

	@Column(name = "user")
	private String user;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	
}
