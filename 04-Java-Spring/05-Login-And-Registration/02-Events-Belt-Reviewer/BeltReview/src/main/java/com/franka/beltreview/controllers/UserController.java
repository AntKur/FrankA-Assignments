package com.franka.beltreview.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.franka.beltreview.models.User;
import com.franka.beltreview.services.UserService;
import com.franka.beltreview.validations.UserValidator;

@Controller
public class UserController {
	@Autowired
	private UserService uSer;
	@Autowired
	private UserValidator uVal;
	
	@GetMapping("")
	public String index(@ModelAttribute("user") User user) {
		return "registerlogin.jsp";
	}
	
	@PostMapping("/register")
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		this.uVal.validateUserRegistration(user, result);
		if(result.hasErrors())
			return "registerlogin.jsp";
		this.uSer.registerUser(user);
		session.setAttribute("user_id", user.getId());
		return "redirect:/events";
	}
	
	@PostMapping("/login")
	public String login(HttpSession session, @RequestParam("email") String email, @RequestParam("password") String password, RedirectAttributes redAtt) {
		if(!this.uSer.validateUser(email, password)) {
			redAtt.addFlashAttribute("errorLogin", "Invalid Credentials");
			return "redirect:/";
		}
		User user = this.uSer.findUserByEmail(email);
		session.setAttribute("user_id", user.getId());
		return "redirect:/events";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
