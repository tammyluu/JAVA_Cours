package org.example.employés_visitor;

public class SalaryAdjuster implements EmployeeVisitor{
    @Override
    public void visit(Manager manager) {
        System.out.println("Evaluating salary for Manager: '" + manager.getName() + "' is 3ndGrade ");
    }

    @Override
    public void visit(Developer developer) {
        System.out.println("Evaluating salary for Developer: '" + developer.getName() + "' is 4thGrade ");
    }

    @Override
    public void visit(Designer designer) {
        System.out.println("Evaluating salary for Designer: '" + designer.getName() + "' is 4thGrade ");
    }
}
