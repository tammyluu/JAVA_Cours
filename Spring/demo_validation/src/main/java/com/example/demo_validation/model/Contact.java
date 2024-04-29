package com.example.demo_validation.model;

import com.example.demo_validation.validation.MyValid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
    @NotNull(message = "on a dis pas null")
    @MyValid(value = "za",message = "on avait dit 'zaza'")
    private String firtName;
    @NotNull
    @Size(min = 3, message = "3 minimun svp")
    private String lastName;
    @Min(3)
    @Max(42)
    private Integer age;


}
