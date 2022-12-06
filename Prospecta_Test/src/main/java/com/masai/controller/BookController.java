package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.BookException;

import com.masai.model.Book;

import com.masai.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@PostMapping("/created")
	public ResponseEntity<Book> createNewUrl(@RequestBody  Book book){
		return new ResponseEntity<Book>(bookService.bookDetails(book), HttpStatus.OK);
	}
	
	
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBookDetailsHandler() throws BookException{
		
		List<Book> books = bookService.getAllBookDetails();
		
		
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
		
	}
	
	
	@DeleteMapping("/students/{roll}")
	public ResponseEntity<Book> deleteStudentByRollHandler(@PathVariable("bookId") Integer bookId) throws BookException{
		
		Book books = bookService.deleteBookBytitle(bookId);
		
		return new ResponseEntity<Book>(books,HttpStatus.OK);
		
	}
	
	@PutMapping("/books")
	public ResponseEntity<Book> updateStudentHandler(@RequestBody Book book) throws BookException{
		
		Book updatedStudent = bookService.updateBookDetails(book);
		
		
		return new ResponseEntity<Book>(updatedStudent,HttpStatus.OK);
		
	}

}
