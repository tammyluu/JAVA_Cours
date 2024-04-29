package org.example.repository;


import org.example.entity.BookEntity;
import org.hibernate.Session;

import java.util.List;


public  abstract class BaseEntityRepository<T> {
    protected Session session;

    public BaseEntityRepository(Session session) {
        this.session = session;
    }

    public BaseEntityRepository() {
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
    public void create(BookEntity elment) {
        this.session.persist(elment);
    }

    public boolean delete(Long element) {
        session.remove(element);
        return false;
    }

    public void update(T element) {
        session.persist(element);
    }

    abstract T findById(Long id);

    abstract List<T> findAll();
}
