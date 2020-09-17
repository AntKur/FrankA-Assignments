package com.franka.routing.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {

		@GetMapping("/{dojo}")
		@ResponseBody
		public String dojo(@PathVariable String dojo) {
			if(dojo.equals("dojo"))
				return "The dojo is awesome!";
			else
				return "Oops! Page not found.";
		}
		
		@GetMapping("/{dojo}/{city}")
		@ResponseBody
		public String dojoBurbank(@PathVariable String dojo,@PathVariable String city) {
			if(dojo.equals("dojo")) {
				if(city.equals("burbank"))
					return "Burbank Dojo is located in Southern California";
				else if(city.equals("san-jose"))
					return "SJ dojo is the headquarters.";
				else
					return "Oops! Page not found.";
			}
			else {
				return "Oops! Page not found.";
			}
		}
		
}
