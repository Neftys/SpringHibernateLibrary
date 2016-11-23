package com.websystique.springmvc.dao.DaoIMPL;

import com.websystique.springmvc.dao.AbstractDao;
import com.websystique.springmvc.dao.DaoInterface.BookDao;
import com.websystique.springmvc.model.Book;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Nif-note on 22.11.2016.
 */
@Repository("BookDao")
public class BookDaoImpl extends AbstractDao<Integer,Book> implements BookDao {
    @Override
    public Book findById(int id) {
        return getByKey(id);
    }

    @Override
    public void saveBook(Book book) {
    persist(book);
    }

    @Override
    public void deleteBookById(int id) {
        Query query = getSession().createSQLQuery("delete from Book where id = :id");
        query.setString(id, "id");
        query.executeUpdate();
    }

    @Override
    public List<Book> findAllBook() {
        Criteria criteria=createEntityCriteria();
        return (List<Book>)criteria.list();
    }
}
