package org.example.employés_visitor;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Designer implements Employee {
    private String name;
    @Override
    public void accept(EmployeeVisitor visitor) {
            visitor.visit(this);
    }
}
