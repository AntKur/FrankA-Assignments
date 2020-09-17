package com.franka.hellohuman.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	@RequestMapping("/")
	public String index(@RequestParam(value="first_name", required=false) String firstName,@RequestParam(value="last_name", required=false) String lastName, Model model) {
		if(firstName == null & lastName == null) {
			model.addAttribute("firstName", "Human");
		} else if(lastName == null){
			model.addAttribute("firstName", firstName);
		} else if(firstName == null) {
			model.addAttribute("lastName", lastName);
		} else {
			model.addAttribute("firstName", firstName);
			model.addAttribute("lastName", lastName);
		}
		return "index.jsp";
	}
}
