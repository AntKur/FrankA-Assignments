package com.franka.dojosurvey.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SurveyController {
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String survey(@ModelAttribute("errors") String errors, Model model, HttpSession session) {
		model.addAttribute("errors", errors);
		return "survey.jsp";
	}
	
	@RequestMapping(path="/result", method=RequestMethod.POST)
	public String result(@RequestParam(value="name") String name,@RequestParam(value="location") String location,@RequestParam(value="language") String language, @RequestParam(value="comment") String comment, HttpSession session, Model model) {
		if(name.equals("")) {
			session.setAttribute("missing", "Name");
			return "redirect:/errors";
		} else if(location.equals("")) {
			session.setAttribute("missing", "Location");
			return "redirect:/errors";
		} else if(language.equals("")) {
			session.setAttribute("missing", "Language");
			return "redirect:/errors";
		} else {
			model.addAttribute("name", name);
			model.addAttribute("location", location);
			model.addAttribute("language", language);
			model.addAttribute("comment", comment);
		}
		return "result.jsp";
	}
	
	@RequestMapping("/errors")
	public String errors(RedirectAttributes redirect, HttpSession session) {
		redirect.addFlashAttribute("errors", session.getAttribute("missing") +" is a required field!");
		return "redirect:/";
	}
}
