package com.franka.displaydate.controllers;

import java.time.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DisplayDateController {
	
	@RequestMapping("/")
	public String main() {
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String date(Model model) {
		LocalDate d = LocalDate.now();
		String day = d.getDayOfWeek() + "";
		day = day.toLowerCase();
		day = day.replaceFirst(Character.toString(day.charAt(0)),Character.toString((char)(day.charAt(0)-32)));
		String month = d.getMonth() +"";
		month = month.toLowerCase();
		month = month.replaceFirst(Character.toString(month.charAt(0)),Character.toString((char)(month.charAt(0)-32)));
		String date = day + ", the " +d.getDayOfMonth() +" of " +month +", " +d.getYear();
		model.addAttribute("date", date);
		return "date.jsp";
	}
	
	
	@RequestMapping("/time")
	public String time(Model model) {
		LocalTime t = LocalTime.now();
		String time;
		String period;
		int hour = t.getHour();
		if(hour>=12) {
			period = "PM";
		}else {
			period = "AM";
		}
		if(hour>12) {
			hour -= 12;
		}
		time = hour +":" +t.getMinute()  +" " +period;
		model.addAttribute("time",time);
		return "time.jsp";
	}
}
