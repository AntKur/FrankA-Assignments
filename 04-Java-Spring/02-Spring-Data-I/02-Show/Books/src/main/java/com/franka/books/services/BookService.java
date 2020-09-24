package com.franka.books.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.franka.books.models.Book;
import com.franka.books.repositories.BookRepository;

@Service
public class BookService {
	
	private final BookRepository bRep;
	
	public BookService(BookRepository bRep) {
		this.bRep = bRep;
	}
	
	public List<Book> allBooks(){
		return bRep.findAll();
	}
	
	public Book createBook(Book b) {
		return bRep.save(b);
	}
	
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bRep.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
}
