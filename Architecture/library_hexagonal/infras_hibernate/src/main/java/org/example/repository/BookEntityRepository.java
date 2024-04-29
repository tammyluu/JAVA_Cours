package org.example.repository;

import org.example.entity.Book;
import org.hibernate.Session;

import java.util.List;

public class BookEntityRepository  extends BaseEntityRepository<Book> {
    public BookEntityRepository(Session session) {
        super(session);
    }
    @Override
    public Book findById(Long id) {
        return getSession().find(Book.class, id);
    }

    @Override
    public List<Book> findAll() {
        return getSession().createQuery("SELECT b FROM BookEntity b", Book.class).getResultList();
    }
}
