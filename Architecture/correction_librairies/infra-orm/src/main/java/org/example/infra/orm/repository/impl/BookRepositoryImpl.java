package org.example.infra.orm.repository.impl;

import org.example.domain.entity.Book;
import org.example.domain.port.BookRepository;
import org.example.infra.orm.entity.BookEntity;
import org.example.infra.orm.repository.BookEntityRepository;
import org.example.infra.orm.util.HibernateSession;
import org.hibernate.Session;

import java.util.List;
import java.util.stream.Collectors;

public class BookRepositoryImpl implements BookRepository {



    private final BookEntityRepository bookEntityRepository;

    public BookRepositoryImpl(BookEntityRepository bookEntityRepository) {
        this.bookEntityRepository = bookEntityRepository;
    }

    @Override
    public void create(Book book) {
        Session session = HibernateSession.getSessionFactory().openSession();
        session.beginTransaction();
        try (session) {
            bookEntityRepository.setSession(session);
            BookEntity bookEntity = BookEntity.builder().author(book.getAuthor()).title(book.getTitle()).build();
            bookEntityRepository.create(bookEntity);
            book.setId(book.getId());
            session.getTransaction().commit();
        }catch (Exception ex) {
            session.getTransaction().rollback();
            throw ex;
        }
    }

    @Override
    public void delete(Book book) {
        Session session = HibernateSession.getSessionFactory().openSession();
        session.beginTransaction();
        try (session) {
            bookEntityRepository.setSession(session);
            BookEntity bookEntity = bookEntityRepository.findById(book.getId());
            bookEntityRepository.delete(bookEntity);
            session.getTransaction().commit();
        }catch (Exception ex) {
            session.getTransaction().rollback();
            throw ex;
        }
    }

    @Override
    public Book findById(int id) {
        Session session = HibernateSession.getSessionFactory().openSession();
        bookEntityRepository.setSession(session);
        try (session) {
            BookEntity bookEntity = bookEntityRepository.findById(id);
            return bookEntity.toBook();
        }
    }

    @Override
    public List<Book> searchBook(String search) {
        Session session = HibernateSession.getSessionFactory().openSession();
        bookEntityRepository.setSession(session);
        try (session) {
            return bookEntityRepository.findAllByKey(search)
                    .stream()
                    .map(bookEntity -> bookEntity.toBook())
                    .collect(Collectors.toList());
        }
    }
}
