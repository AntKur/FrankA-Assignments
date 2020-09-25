package com.franka.books.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.franka.books.models.Book;
import com.franka.books.services.BookService;

@Controller
public class BookController {
	private final BookService bSer;
	
	public BookController(BookService bSer) {
		this.bSer = bSer;
	}
	
	@RequestMapping("/books")
	public String index(Model model) {
		List<Book> books = bSer.allBooks();
		model.addAttribute("books",books);
		return "index.jsp";
	}
	
	@RequestMapping(value="/books/new")
	public String newBook(@ModelAttribute("book") Book book) {
		return "newbook.jsp";
	}
	
	@RequestMapping(value="/books", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if(result.hasErrors())
			return "redirect:/books/new";
		else {
			bSer.createBook(book);
			return "redirect:/books";
		}
	}
	
	
	@RequestMapping("/books/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Book b = bSer.findBook(id);
		model.addAttribute("book", b);
		return "showbook.jsp";
	}
	
	@RequestMapping("/books/{id}/edit")
	public String editBook(@PathVariable("id") Long id, Model model) {
		Book book = bSer.findBook(id);
		if(book != null) {
			model.addAttribute("book", book);
			return "editbook.jsp";
		} else {
			return "redirect:/books";
		}	
	}
	
	@RequestMapping(value="/books/{id}/edit",method=RequestMethod.POST)
	public String updateBook(@PathVariable("id") Long id, @Valid @ModelAttribute("book") Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "editbook.jsp";
		} else {
			bSer.updateBook(id, book);
			return "redirect:/books";
		}
	}
	
	@RequestMapping(value="/books/{id}/delete")
	public String deleteBook(@PathVariable("id") Long id) {
		bSer.deleteBook(id);
		return "redirect:/books";
	}
}
