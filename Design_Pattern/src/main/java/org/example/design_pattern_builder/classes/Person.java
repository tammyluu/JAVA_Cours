package org.example.design_pattern_builder.classes;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {
    private  String firstname;
    private  String lastname;
}
