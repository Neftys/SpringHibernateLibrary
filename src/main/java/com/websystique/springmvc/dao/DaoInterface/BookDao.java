package com.websystique.springmvc.dao.DaoInterface;

import com.websystique.springmvc.model.Book;
import com.websystique.springmvc.model.Employee;

import java.util.List;

/**
 * Created by Nif-note on 22.11.2016.
 */
public interface BookDao {

    Book findById(int id);

    void saveBook(Book book);

    void deleteBookById(int id);

    List<Book> findAllBook();
}
