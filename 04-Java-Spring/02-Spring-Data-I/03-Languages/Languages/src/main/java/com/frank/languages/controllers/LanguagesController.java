package com.frank.languages.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.frank.languages.models.Language;
import com.frank.languages.services.LanguageService;

@Controller
public class LanguagesController {
	private final LanguageService lSer;
	
	public LanguagesController(LanguageService lSer) {
		this.lSer = lSer;
	}
	
	@RequestMapping("/languages")
	public String index(Model model) {
		model.addAttribute("languages", lSer.allLangs());
		return "index.jsp";
	}
	
	@RequestMapping("/languages/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		model.addAttribute("language",lSer.findLang(id));
		return "show.jsp";
	}
	
	@RequestMapping("/languages/new")
	public String newLang(@ModelAttribute("language") Language language) {
		return "new.jsp";
	}
	
	@RequestMapping(value="/languages", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if(result.hasErrors()) {
			return "new.jsp";
		} else {
			lSer.createLang(language);
			return "redirect:/languages";
		}
	}
	
	@RequestMapping("/languages/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		model.addAttribute("language", lSer.findLang(id));
		return "edit.jsp";
	}
	
	@RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		} else {
			lSer.updateLang(language);
			return "redirect:/languages";
		}
	}
	
	@RequestMapping(value="/languages/{id}", method=RequestMethod.DELETE)
	public String delete(@PathVariable("id") Long id) {
		lSer.deleteLang(id);
		return "redirect:/languages";
	}
}
