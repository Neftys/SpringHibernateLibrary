package com.websystique.springmvc.service.ServiceInterface;

import com.websystique.springmvc.model.Book;

import java.util.List;

public interface BookService {

	Book findById(int id);

	List<Book> findAllBook();
	
	 void saveBook(Book book);


	
}
