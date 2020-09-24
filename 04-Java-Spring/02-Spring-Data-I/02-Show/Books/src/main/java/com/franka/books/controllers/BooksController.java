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
public class BooksController {
	private final BookService bSer;
	
	public BooksController(BookService bSer) {
		this.bSer = bSer;
	}
	
	@RequestMapping("/books")
	public String index(Model model) {
		List<Book> books = bSer.allBooks();
		model.addAttribute("books", books);
		return "index.jsp";
	}
	
	@RequestMapping("/books/new")
	public String newBook(@ModelAttribute("book") Book book) {
		return "newbook.jsp";
	}
	
	@RequestMapping(value="/books/new", method=RequestMethod.POST)
		public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
			if(result.hasErrors()) {
				return "newbook.jsp";
			} else {
				bSer.createBook(book);
				return "redirect:/books";
			}
		}
	
	
	/*
	@RequestMapping(value="/books", method=RequestMethod.POST)
	public Book create(@RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
		Book book = new Book(title, desc, lang, numOfPages);
		return bSer.createBook(book);
	}
	*/
	
	@RequestMapping("/books/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Book book = bSer.findBook(id);
		model.addAttribute("book",book);
		return "book.jsp";
	}
	
}
