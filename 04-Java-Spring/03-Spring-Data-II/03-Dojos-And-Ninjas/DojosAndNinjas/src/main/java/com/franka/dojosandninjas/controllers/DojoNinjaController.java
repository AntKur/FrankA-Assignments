package com.franka.dojosandninjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.franka.dojosandninjas.models.Dojo;
import com.franka.dojosandninjas.models.Ninja;
import com.franka.dojosandninjas.services.DojoNinjaServices;

@Controller
public class DojoNinjaController {
	private final DojoNinjaServices ser;
	
	public DojoNinjaController(DojoNinjaServices ser) {
		this.ser = ser;
	}
	
	@RequestMapping("/dojos")
	public String dojos(Model model) {
		model.addAttribute("dojos", ser.getAllDojos());
		return "dojos.jsp";
	}
	
	@RequestMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "newdojo.jsp";
	}
	
	@RequestMapping(value="/dojos", method=RequestMethod.POST)
	public String createNewDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors())
			return "newdojo.jsp";
		ser.createDojo(dojo);
		return "redirect:/dojos";
	}
	
	@RequestMapping("/dojos/{id}")
	public String showDojo(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dojo", ser.findDojo(id));
		return "showdojo.jsp";
	}
	
	@RequestMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		model.addAttribute("dojos", ser.getAllDojos());
		return  "newninja.jsp";
	}
	
	@RequestMapping(value="/ninjas", method=RequestMethod.POST)
	public String createNewNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			return "newninja.jsp";
		}	
		ser.createNinja(ninja);
		return "redirect:/dojos";
	}
}
