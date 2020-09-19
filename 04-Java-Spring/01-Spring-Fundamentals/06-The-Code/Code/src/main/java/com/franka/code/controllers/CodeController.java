package com.franka.code.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CodeController {

	@GetMapping("/")
	public String crack(@ModelAttribute("errors") String errors, Model model ) {
		model.addAttribute("errors", errors);
		return "crack.jsp";
	}
	
	@RequestMapping(path="/code", method=RequestMethod.POST)
	public String cracked(@RequestParam(value="code") String code) {
		if(code.equals("bushido"))
			return "cracked.jsp";
		else
			return "redirect:/errors";
	}
	
	@RequestMapping("/errors")
	public String errors(RedirectAttributes redirect){
		redirect.addFlashAttribute("errors", "You must train harder!");
		return "redirect:/";
	}
		
	

}
