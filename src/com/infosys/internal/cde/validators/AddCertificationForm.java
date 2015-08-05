package com.infosys.internal.cde.validators;

import org.hibernate.validator.constraints.NotEmpty;

public class AddCertificationForm {
	private Long certificationId;
	@NotEmpty
	private String businessLine;
	@NotEmpty
	private String certificationName;
	@NotEmpty
	private String examPattern;
	public Long getCertificationId() {
		return certificationId;
	}
	public void setCertificationId(Long certificationId) {
		this.certificationId = certificationId;
	}
	public String getBusinessLine() {
		return businessLine;
	}
	public void setBusinessLine(String businessLine) {
		this.businessLine = businessLine;
	}
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
	
	
 }

