package com.websystique.springmvc.service.ServiceImpl;

import com.websystique.springmvc.dao.DaoInterface.BookDao;
import com.websystique.springmvc.model.Book;
import com.websystique.springmvc.service.ServiceInterface.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("BookService")
@Transactional
public class BookServiceImpl implements BookService {

	@Autowired
	@Qualifier(value = "BookDao")
	private BookDao dao;
	
	public Book findById(int id) {
		return dao.findById(id);
	}


	public List<Book> findAllBook() {
		return dao.findAllBook();
	}

	@Override
	public void saveBook(Book book) {
		dao.saveBook(book);
	}
}
