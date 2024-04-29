package com.example.tasklist.entity;

import com.example.tasklist.dto.TaskDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String content;
    private boolean isDone = false;
    public TaskDTO taskDTO;

    public Task(String content, boolean isDone) {
        this.content = content;
        this.isDone = isDone;
    }


}
