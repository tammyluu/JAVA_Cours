package org.example.spi.port;

import org.example.entity.Todo;

import java.util.List;

public interface TodoRepository {
    boolean create(Todo todo);
    boolean delete(Long id);

    boolean update(Todo todo);

    Todo findById(Long id);

    List<Todo> findAll();
}
