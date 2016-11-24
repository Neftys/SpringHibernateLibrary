package com.websystique.springmvc.dao.DaoIMPL;

import com.websystique.springmvc.dao.AbstractDao;
import com.websystique.springmvc.dao.DaoInterface.AuthorDao;
import com.websystique.springmvc.dao.DaoInterface.BookDao;
import com.websystique.springmvc.model.Author;
import com.websystique.springmvc.model.Book;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Nif-note on 22.11.2016.
 */
@Repository("AuthorDao")
public class AuthorDaoImpl extends AbstractDao<Integer,Author> implements AuthorDao {

    @Override
    public void saveAuthor(Author author) {
        persist(author);
    }

    @Override
    public void deleteAuthorById(int id) {
        Query query = getSession().createSQLQuery("delete from author where id = :id");
        query.setString(id, "id");
        query.executeUpdate();
    }

    @Override
    public List<Author> findAllAuthor() {
        Criteria criteria=createEntityCriteria();
        return (List<Author>)criteria.list();
    }

    @Override
    public Author findById(int id) {
        return getByKey(id);
    }



}
