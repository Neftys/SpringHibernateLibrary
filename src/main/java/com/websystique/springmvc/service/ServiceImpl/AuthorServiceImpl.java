package com.websystique.springmvc.service.ServiceImpl;

import com.websystique.springmvc.dao.DaoInterface.AuthorDao;
import com.websystique.springmvc.dao.DaoInterface.BookDao;
import com.websystique.springmvc.model.Author;
import com.websystique.springmvc.model.Book;
import com.websystique.springmvc.service.ServiceInterface.AuthorService;
import com.websystique.springmvc.service.ServiceInterface.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("AuthorService")
@Transactional
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	@Qualifier(value = "AuthorDao")
	private AuthorDao dao;


	public Author findById(int id) {
		return dao.findById(id);
	}


	public List<Author> findAllAuthor() {
		return dao.findAllAuthor();
	}

	public void saveAuthor(Author author) {
		dao.saveAuthor(author);
	}


}
