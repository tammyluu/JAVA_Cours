package com.example.tasklist.dto;

import com.example.tasklist.entity.Task;
import lombok.Builder;
import lombok.Value;

import java.io.Serializable;

@Value
@Builder
public class TaskDTO  implements Serializable {

    int id;
    String content;
    boolean isDone;

}
