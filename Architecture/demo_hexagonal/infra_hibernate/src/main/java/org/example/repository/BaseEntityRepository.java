package org.example.repository;

import org.hibernate.Session;

import java.util.List;

public abstract class BaseEntityRepository<T> {
    protected Session session;

    public Session getSession() {
        return session;
    }

    public BaseEntityRepository() {

    }

    public void setSession(Session session) {
        this.session = session;
    }

    public void create(T elment) {
        this.session.persist(elment);
    }

    public void delete(T element) {
        session.remove(element);
    }

    public void update(T element) {
        session.persist(element);
    }

    abstract T findById(Long id);

    abstract List<T> findAll();
}
