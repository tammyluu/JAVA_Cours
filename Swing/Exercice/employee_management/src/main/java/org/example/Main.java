package org.example;

import org.example.controller.DepartmentController;

public class Main {
    public static void main(String[] args) {
        System.out.println("Classpath: " + System.getProperty("java.class.path"));

        new DepartmentController();
    }
}