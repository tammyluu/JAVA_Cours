package com.example.todolist.repository;

import com.example.todolist.entity.Todo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Collections;
import java.util.List;


@ApplicationScoped
public class TodoRepository extends Repository<Todo> {
    @Inject
    public TodoRepository(SessionFactory sessionFactory) {
        this.session = sessionFactory.openSession();
    }


    @Override
    public Todo findById(Long id) {
        return session.get(Todo.class, id);
    }

    @Override
    public List<Todo> findAll() {
        try (Session session = getSession()) {
            return session.createQuery("FROM Todo", Todo.class).list();
        } catch (Exception e) {
          throw new RuntimeException("Error while fetching todos", e);
        }
    }

    public void update(Todo todo) {
        try {
            session.beginTransaction();
            session.merge(todo);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw new RuntimeException("Error while updating todo", e);
        }
    }
    public void delete(Long id) {
        try {
            session.beginTransaction();
            Todo todo = findById(id);
            if (todo != null) {
                session.remove(todo);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw new RuntimeException("Error while deleting todo", e);
        }
    }

}
