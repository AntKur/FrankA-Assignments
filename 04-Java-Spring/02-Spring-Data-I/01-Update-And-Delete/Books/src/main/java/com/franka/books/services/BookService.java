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
		Optional<Book> oB = bRep.findById(id);
		if(oB.isPresent())
			return oB.get();
		else
			return null;
	}
	
	public Book updateBook(Long id, Book uBook) {
		Book book = findBook(id);
		book.setDescription(uBook.getDescription());
		book.setLanguage(uBook.getLanguage());
		book.setNumOfPages(uBook.getNumOfPages());
		book.setTitle(uBook.getTitle());
		return bRep.save(book);
		
	}
	
	public void deleteBook(Long id) {
		bRep.deleteById(id);	
	}
}
