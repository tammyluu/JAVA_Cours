package org.example.repository;

import org.example.entity.Todo;
import org.example.entity.TodoEntity;
import org.example.spi.port.TodoRepository;

import java.util.List;

public class TodoRepositoryImpl implements TodoRepository {


    private TodoEntityRepository todoEntityRepository;

    public TodoRepositoryImpl() {
        todoEntityRepository = new TodoEntityRepository();
    }

    @Override
    public boolean create(Todo todo) {
        try {
            //ouvrir session hibernate
            //ouvrir transaction
            TodoEntity todoEntity = TodoEntity.builder()
                    .content(todo.getContent())
                    .status(todo.getStatus())
                    .build();
            todoEntityRepository.create(todoEntity);
            todo.setId(todoEntity.getId());
            return true;
        }catch (Exception exception) {
            return false;
        }
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public boolean update(Todo todo) {
        return false;
    }

    @Override
    public Todo findById(Long id) {
        return null;
    }

    @Override
    public List<Todo> findAll() {
        return null;
    }
}
