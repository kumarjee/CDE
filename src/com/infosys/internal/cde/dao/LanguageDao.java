package com.infosys.internal.cde.dao;

import java.util.List;

import com.infosys.internal.cde.model.Language;

public interface LanguageDao {
	public List<Language> listLanguages();

	public List<Language> getLanguageByLanguageId(Long languageId);
}
