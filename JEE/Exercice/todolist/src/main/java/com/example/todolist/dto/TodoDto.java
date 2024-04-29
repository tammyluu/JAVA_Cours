package com.example.todolist.dto;

import com.example.todolist.entity.Todo;
import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link com.example.todolist.entity.Todo}
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoDto {
    Long id;
    String content;
    boolean status;

    public Todo toEntity() {
        return Todo.builder()
                .content(content)
                .status(status)
                .build();
    }
}