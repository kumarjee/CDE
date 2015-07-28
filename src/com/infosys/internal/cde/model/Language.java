package com.infosys.internal.cde.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@SuppressWarnings("serial")
@Table(name = "language")
public class Language {

	@Id
	@GeneratedValue
	@Column(name = "lang_id")
	private Long languageId;

	@Column(name = "lang_name")
	private String languageName;

	public void setLanguageId(Long languageId) {
		this.languageId = languageId;
	}

	public Long getLanguageId() {
		return languageId;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	public String getLanguageName() {
		return languageName;
	}
}
