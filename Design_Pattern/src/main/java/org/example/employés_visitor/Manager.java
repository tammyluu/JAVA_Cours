package org.example.employés_visitor;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Manager implements Employee {
    private String name;
    private int fullProject;
    private int clientSatisfaction;
    @Override
    public void accept(EmployeeVisitor visitor) {
        visitor.visit(this);
    }
}
