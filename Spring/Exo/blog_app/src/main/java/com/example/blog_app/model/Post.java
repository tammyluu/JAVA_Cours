package com.example.blog_app.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Post {
    private UUID id;

    @NotBlank(message = "Title cannot be empty")
    @NotNull
    @Size(max = 100, message = "Title cannot exceed 100 characters")
    private String title;

    @Size(min = 10, max = 100, message = "Description must be between 10 and 100 characters")
    private String description;

    @Size(min = 10, max = 100, message = "Content must be between 10 and 100 characters")
    private String content;
    private List<Comment> comments = new ArrayList<>();
}
