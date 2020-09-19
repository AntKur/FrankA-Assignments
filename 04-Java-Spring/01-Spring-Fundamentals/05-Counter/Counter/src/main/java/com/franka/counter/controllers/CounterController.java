package com.franka.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterController {
	
	@RequestMapping("/")
	public String page(HttpSession session) {
		if(session.getAttribute("count") == null)
			session.setAttribute("count", 0);
		session.setAttribute("count", (Integer)session.getAttribute("count") + 1);
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String page(HttpSession session, Model model) {
		if(session.getAttribute("count") == null)
			session.setAttribute("count", 0);
		model.addAttribute("count", (Integer)session.getAttribute("count"));
		return "counter.jsp";
	}
}
