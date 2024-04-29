package com.example.blog_app.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private UUID id;

    @NotBlank(message = "Full name cannot  empty")
    @Size(min=3, max = 50, message = "Full name  must be between 3 and 50 characters please")
    private String fullName;

    @NotBlank(message = "Email required")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Content cannot be blank")
    @Size(min=20, max = 300, message = "Content must be between 20 and 300 characters please")
    private String content;
}
