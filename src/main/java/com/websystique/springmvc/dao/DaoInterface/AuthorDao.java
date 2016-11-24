package com.websystique.springmvc.dao.DaoInterface;

import com.websystique.springmvc.model.Author;
import com.websystique.springmvc.model.Book;

import java.util.List;

/**
 * Created by Ниф on 24.11.2016.
 */
public interface AuthorDao {
    Author findById(int id);

    void saveAuthor(Author author);

    void deleteAuthorById(int id);

    List<Author> findAllAuthor();
}
