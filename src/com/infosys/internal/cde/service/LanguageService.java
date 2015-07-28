package com.infosys.internal.cde.service;

import java.util.List;

import com.infosys.internal.cde.model.Language;

public interface LanguageService {
	public List<Language> listLanguages();

	public List<Language> getLanguageByLanguageId(Long languageId);
}
