package com.masai.service;



import java.util.List;

import com.masai.exception.BookException;

import com.masai.model.Book;


public interface BookService {

public Book bookDetails(Book book);
	
	
public List<Book> getAllBookDetails()throws BookException;
	
	
public Book deleteBookBytitle(Integer bookId)throws BookException;

public Book updateBookDetails(Book book)throws BookException;
	
}
