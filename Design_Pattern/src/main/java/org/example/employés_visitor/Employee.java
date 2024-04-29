package org.example.employés_visitor;

public interface Employee {
    void accept(EmployeeVisitor visitor);
}
