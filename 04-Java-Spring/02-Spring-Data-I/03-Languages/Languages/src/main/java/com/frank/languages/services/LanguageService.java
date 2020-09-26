package com.frank.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.frank.languages.models.Language;
import com.frank.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository lRep;
	
	public LanguageService(LanguageRepository lRep) {
		this.lRep = lRep;
	}
	
	public List<Language> allLangs(){
		return lRep.findAll();
	}
	
	public Language findLang(Long id) {
		Optional<Language> l = lRep.findById(id);
		if(l.isPresent()) {
			return l.get();
		}else {
			return null;
		}
	}
	
	public Language createLang(Language lang) {
		return lRep.save(lang);
	}
	
	public Language updateLang(Language lang) {
		return lRep.save(lang);
	}
	
	public void deleteLang(Long id) {
		lRep.deleteById(id);
	}
}
