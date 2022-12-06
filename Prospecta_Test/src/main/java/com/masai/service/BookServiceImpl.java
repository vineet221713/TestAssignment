package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.masai.exception.BookException;

import com.masai.model.Book;

import com.masai.repository.BookDao;

@Service
public class BookServiceImpl implements BookService{

	private BookDao bookdao;
	
	@Override
	public Book bookDetails(Book book) {
		
		Book b = bookdao.save(book);
		return b;
		
	}
	
	@Override
	public List<Book> getAllBookDetails() throws BookException {
    List<Book> books = bookdao.findAll();
		
		if(books.size() > 0)
			return books;
		else
			throw new BookException("No Book found..");
		
		
	}
	

	@Override
	public Book deleteBookBytitle(Integer bookId) throws BookException {
Optional<Book> opt= bookdao.findById(bookId);
		
		if(opt.isPresent()) {
			
			 Book existingbook= opt.get();
			 
			 bookdao.delete(existingbook);
			
			 return existingbook;
		}else
			throw new BookException("Book does not exist with id :"+bookId);
	}

	@Override
	public Book updateBookDetails(Book book) throws BookException {
   Optional<Book> opt = bookdao.findById(book.getBookId());
		
		
		if(opt.isPresent()) {
			
			return bookdao.save(book);
			
		}
		else
			throw new BookException("Invalid Book details");	
	}
	

}
