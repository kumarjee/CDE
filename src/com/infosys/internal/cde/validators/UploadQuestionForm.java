package com.infosys.internal.cde.validators;

import org.springframework.web.multipart.MultipartFile;

public class UploadQuestionForm {
	
	private Long certificationId;
	
	private MultipartFile file;

	public Long getCertificationId() {
		return certificationId;
	}

	public void setCertificationId(Long certificationId) {
		this.certificationId = certificationId;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

}
