package org.example.repository;

import org.example.entity.TodoEntity;

import java.util.List;

public class TodoEntityRepository extends BaseEntityRepository<TodoEntity> {
    @Override
    TodoEntity findById(Long id) {
        return null;
    }

    @Override
    List<TodoEntity> findAll() {
        return null;
    }
}
