package com.example.student.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private UUID id;
    @NotNull(message = "Try again")
    @NotBlank
    @Size(min=3, message = "Longer not allowed")
    private String firstName;

    @NotNull(message = "Try again")
    @NotBlank
    @Size(min=3, message = "Longer not allowed")
    private String lastName;

    @Min(18)
    private  int age;

    @Email
    private  String email;

    @Null
    private String thumbnail;


}
