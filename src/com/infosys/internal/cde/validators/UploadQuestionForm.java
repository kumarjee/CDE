package com.infosys.internal.cde.validators;

import org.springframework.web.multipart.MultipartFile;

public class UploadQuestionForm {
	
	private Long languageId;
	
	private MultipartFile file;

	public Long getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Long languageId) {
		this.languageId = languageId;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

}
