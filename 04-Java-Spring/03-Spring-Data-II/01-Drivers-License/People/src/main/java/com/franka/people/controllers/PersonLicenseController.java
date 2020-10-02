package com.franka.people.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.franka.people.models.License;
import com.franka.people.models.Person;
import com.franka.people.services.PersonLicenseService;

@Controller
public class PersonLicenseController {
	private final PersonLicenseService ser;
	
	public PersonLicenseController(PersonLicenseService ser) {
		this.ser = ser;
	}

	@RequestMapping("/persons")
	public String index(Model model) {
		model.addAttribute("people",ser.findAllPersons());
		return "index.jsp";
	}
	
	@RequestMapping("/persons/new")
	public String newPerson(@ModelAttribute("person") Person person) {
		return "newperson.jsp";
	}
	
	@RequestMapping("/persons/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		model.addAttribute("person", ser.findPerson(id));
		return "show.jsp";
	}
	
	@PostMapping("/persons")
	public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if(result.hasErrors()) {
			return "newperson.jsp";
		} else {
			ser.createPerson(person);
			return "redirect:/persons";
		}
	}
	
	@RequestMapping("/licenses/new")
	public String newLicense(@ModelAttribute("license") License license,Model model) {
		model.addAttribute("people",ser.unlicensedPersons());
		return "newlicense.jsp";
	}
	
	@PostMapping("/licenses")
	public String createLicense(@Valid @ModelAttribute("license") License license, BindingResult result) {
		if(result.hasErrors()) {
			return "newlicense.jsp";		
		} else {
			ser.createLicense(license);
			return "redirect:/persons";
		}
	}
}
