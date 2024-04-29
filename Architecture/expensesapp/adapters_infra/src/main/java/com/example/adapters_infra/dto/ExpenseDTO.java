package com.example.adapters_infra.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExpenseDTO {
    private Long id;
    private String title;
    private double sum;


    public ExpenseDTO(String title, double sum) {
        this.title = title;
        this.sum = sum;
    }
}
