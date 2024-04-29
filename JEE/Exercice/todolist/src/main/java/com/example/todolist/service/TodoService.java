package com.example.todolist.service;


import com.example.todolist.dto.TodoDto;
import com.example.todolist.entity.Todo;
import com.example.todolist.exception.RepositoryException;
import com.example.todolist.repository.TodoRepository;
import com.example.todolist.util.HibernateSession;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import org.hibernate.Session;

import java.util.List;

@ApplicationScoped
public class TodoService {

    private final TodoRepository todoRepository;

    @Inject
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public TodoDto createTodo(TodoDto todoDto) {
        Todo todo = todoDto.toEntity();
        Session session = HibernateSession.getSessionFactory().openSession();
        todoRepository.setSession(session);
        session.beginTransaction();
        try {
            todoRepository.create(todo);
            session.getTransaction().commit();
            return todo.toDto();
        }catch (Exception ex) {
            session.getTransaction().rollback();
            throw ex;
        }finally {
            session.close();
        }
    }
    public Todo getTodoById(Long id) {
        Session session = HibernateSession.getSessionFactory().openSession();
        todoRepository.setSession(session);
        session.beginTransaction();
        try {
            Todo todo = todoRepository.findById(id);
            session.getTransaction().commit();
            return todo;
        }catch (Exception ex) {
            session.getTransaction().rollback();
            throw new RepositoryException();
        }finally {
            session.close();
        }
    }

    public Todo updateStatus(Long id, boolean status) {
        return Todo.builder().status(status).build();
    }

    public String delete(Long id) {
        try {
            Todo todo = todoRepository.findById(id);
            if (todo == null) {
                throw new NotFoundException("Todo with ID " + id + " not found");
            }

            todoRepository.delete(id);
            return "Todo with ID " + id + " deleted successfully";
        } catch (Exception ex) {
            throw ex;
        }
    }

    public List<Todo> getAllTodos() throws RepositoryException {
        Session session = HibernateSession.getSessionFactory().openSession();
        List<Todo> todos = null;
        todoRepository.setSession(session);
        session.beginTransaction();
        try {
            todos = todoRepository.findAll();
            session.getTransaction().commit();
        }catch (Exception ex) {
            session.getTransaction().rollback();
            throw new RepositoryException();
        }finally {
            session.close();
        }
        return todos;
    }
}
