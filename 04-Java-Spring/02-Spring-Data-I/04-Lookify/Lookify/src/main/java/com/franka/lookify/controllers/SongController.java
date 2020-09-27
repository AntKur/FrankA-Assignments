package com.franka.lookify.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.franka.lookify.models.Song;
import com.franka.lookify.services.SongService;

@Controller
public class SongController {
	private final SongService sSer;
	
	public SongController(SongService sSer) {
		this.sSer = sSer;
	}
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
		model.addAttribute("songs", sSer.getAllSongs());
		return "dashboard.jsp";
	}
	
	@RequestMapping("/songs/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		model.addAttribute("song", sSer.findSong(id));
		return "show.jsp";
	}
	
	@RequestMapping("/search")
	public String search(@RequestParam("search") String search) {
		return "redirect:/search/"+search+"";
	}
	
	@RequestMapping("/search/{search}")
	public String searchResults(@PathVariable("search") String s, Model model) {
		model.addAttribute("search",s);
		model.addAttribute("songs", sSer.searchByArtist(s));
		return "results.jsp";
	}
	
	@RequestMapping("/songs/new")
	public String newSong(@ModelAttribute("song") Song song) {
		return "new.jsp";
	}
	
	@RequestMapping(value="/dashboard", method=RequestMethod.POST)
	public String createSong(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if(result.hasErrors()) {
			return "new.jsp";
		} else {
			sSer.createSong(song);
			return "redirect:/dashboard";
		}
	}
	
	@RequestMapping(value="/songs/{id}", method=RequestMethod.DELETE)
	public String delete(@PathVariable("id") Long id) {
		sSer.deleteSong(id);
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/search/topTen")
	public String top(Model model) {
		model.addAttribute("songs", sSer.getSortedSongs());
		return "top.jsp";
	}
}
