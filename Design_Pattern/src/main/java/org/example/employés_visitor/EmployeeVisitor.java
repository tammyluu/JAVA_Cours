package org.example.employés_visitor;

public interface EmployeeVisitor {
    void visit(Manager manager);
    void visit(Developer developer);
    void visit(Designer designer);
}
