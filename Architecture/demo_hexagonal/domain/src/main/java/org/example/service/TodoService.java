package org.example.service;

import org.example.entity.Todo;
import org.example.spi.port.TodoRepository;

public class TodoService {

    private final TodoRepository todoRepository;


    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo createTodo(String content, boolean status) {
        Todo todo = new Todo(content, status);
        if(todoRepository.create(todo)) {
            return todo;
        }
        //pour l'exemple uniquement
        throw new RuntimeException();
    }
    //Autre méthodes
}
