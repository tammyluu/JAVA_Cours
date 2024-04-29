package org.example.employés_visitor;

public class Main {
    public static void main(String[] args) {
        // Create instances of different types of employees
        Employee manager = new Manager("John",10,20);
        Employee developer = new Developer("Alice");
        Employee designer = new Designer("Bob");

        // Create visitors
        EmployeeVisitor performanceEvaluator = new PerformanceEvaluator();
        EmployeeVisitor salaryAdjuster = new SalaryAdjuster();

        // Test with different scenarios
        manager.accept(performanceEvaluator);
        developer.accept(performanceEvaluator);
        designer.accept(performanceEvaluator);

        manager.accept(salaryAdjuster);
        developer.accept(salaryAdjuster);
        designer.accept(salaryAdjuster);
    }
}
