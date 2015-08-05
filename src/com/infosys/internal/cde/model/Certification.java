package com.infosys.internal.cde.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@SuppressWarnings("serial")
@Table(name = "certification")
public class Certification {

	@Id
	@GeneratedValue
	@Column(name = "cert_id")
	private Long certificationId;

	@Column(name = "certification_name")
	private String certificationName;

	@Column(name="exam_pattern")
	private String examPattern;
	
	@Column(name="business_line")
	private String businessLine;

	public String getCertificationName() {
		return certificationName;
	}

	public void setCertificationName(String certificationName) {
		this.certificationName = certificationName;
	}

	public String getExamPattern() {
		return examPattern;
	}

	public void setExamPattern(String examPattern) {
		this.examPattern = examPattern;
	}

	public String getBusinessLine() {
		return businessLine;
	}

	public void setBusinessLine(String businessLine) {
		this.businessLine = businessLine;
	}

	public Long getCertificationId() {
		return certificationId;
	}

	public void setCertificationId(Long certificationId) {
		this.certificationId = certificationId;
	}
	
	
}
