package com.franka.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.franka.authentication.models.User;
import com.franka.authentication.services.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService uSer;
	
	@GetMapping("/registration")
	public String registerForm(@ModelAttribute("user") User user) {
		return "registrationPage.jsp";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login.jsp";
	}
	
	@PostMapping("/registration")
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "registrationPage.jsp";
		} else {
			uSer.registerUser(user);
			session.setAttribute("userId", user.getId());
			return "redirect:/home";
		}
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session){
		if(uSer.verifyUser(email, password)) {
			session.setAttribute("userId", uSer.getByEmail(email).getId());
			return "redirect:/home";
		} else {
			model.addAttribute("error", "User authentication failed! Try again.");
			return "login.jsp";
		}
	}
	
	@GetMapping("/home")
	public String home(HttpSession session, Model model) {
		User user = uSer.getById((Long) session.getAttribute("userId"));
		model.addAttribute("user", user);
		return "home.jsp";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
		
}
