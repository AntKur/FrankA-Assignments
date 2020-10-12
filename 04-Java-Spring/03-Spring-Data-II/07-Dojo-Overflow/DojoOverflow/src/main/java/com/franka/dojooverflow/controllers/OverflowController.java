package com.franka.dojooverflow.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.franka.dojooverflow.models.Answer;
import com.franka.dojooverflow.models.Question;
import com.franka.dojooverflow.services.AppService;

@Controller
public class OverflowController {
	@Autowired
	private AppService ser;
	
	@GetMapping("/questions")
	public String index(Model model) {
		model.addAttribute("questions", ser.getQuestions());
		return "index.jsp";
	}
	
	@GetMapping("/questions/new")
	public String newQuestion(@ModelAttribute("question") Question question) {
		return "newq.jsp";
	}
	
	@PostMapping("/questions")
	public String createQuestion(@Valid @ModelAttribute("question") Question question, BindingResult result) {
		System.out.println(question.getTagString());
		if(result.hasErrors())
			return "newq.jsp";
		ser.createNewQuestion(question);
		return "redirect:/questions";
	}
	
	@GetMapping("/questions/{id}")
	public String showQuestion(@PathVariable("id") Long id, @ModelAttribute("answ") Answer answ, Model model) {
		model.addAttribute("question", ser.getQuestionById(id));
		return "show.jsp";
	}
	
	@PostMapping("/questions/{id}/addanswer")
	public String addAnswer(@PathVariable("id") Long id, @Valid @ModelAttribute("answ") Answer answ, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "show.jsp";
		}	
		ser.createAnswer(answ);
		return "redirect:/questions/";
	}
}
