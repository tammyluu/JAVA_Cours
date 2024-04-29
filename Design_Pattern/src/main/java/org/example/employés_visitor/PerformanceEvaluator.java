package org.example.employés_visitor;

public class PerformanceEvaluator implements EmployeeVisitor {
    @Override
    public void visit(Manager manager) {
        System.out.println("Evaluating performance for manager " + manager.getName());
        double scorePreformance = calculatePerformanceScore(manager.getFullProject(), manager.getClientSatisfaction());
        System.out.println("Manager performance score: " + scorePreformance);
    }

    @Override
    public void visit(Developer developer) {
        System.out.println("Evaluating performance for developer " + developer.getName());

    }

    @Override
    public void visit(Designer designer) {
        System.out.println("Evaluating performance for developer " + designer.getName());
    }
    private double calculatePerformanceScore(int fullProjects, int clientSatisfaction) {

        return  (double) (fullProjects + clientSatisfaction) /2;
    }
}
