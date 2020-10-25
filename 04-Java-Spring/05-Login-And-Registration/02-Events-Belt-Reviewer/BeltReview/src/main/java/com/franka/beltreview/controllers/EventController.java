package com.franka.beltreview.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.franka.beltreview.models.Event;
import com.franka.beltreview.models.User;
import com.franka.beltreview.services.EventService;
import com.franka.beltreview.services.UserService;

@RequestMapping("/events")
@Controller
public class EventController {
	@Autowired
	private EventService eSer;
	@Autowired
	private UserService uSer;
	
	@GetMapping("")
	public String dashboard(@ModelAttribute("event") Event event, Model model, HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		if(userId == null)
			return "redirect:/";
		User user = uSer.findUserById(userId);
		model.addAttribute("user", user);
		model.addAttribute("eventsInState", eSer.eventsInState(user.getState()));
		model.addAttribute("eventsOutState", eSer.eventsOutsideOfState(user.getState()));
		return "userdashboard.jsp";
	}
	
	@PostMapping("/new")
	public String createEvent(@Valid @ModelAttribute("event") Event event, BindingResult result, HttpSession session) {
		if((Long)session.getAttribute("user_id") == null)
			return "redirect:/";
		if(result.hasErrors())
			return "userdashboard.jsp";
		eSer.createEvent(event);
		return "redirect:/events";
	}
}
