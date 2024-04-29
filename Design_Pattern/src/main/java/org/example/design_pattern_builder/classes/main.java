package org.example.design_pattern_builder.classes;

public class main {
    public static void main(String[] args) {
        Pizza pizza = new Pizza.Builder()
                .garnitures("g1").garnitures("g2")
                .taille("taille 1")
                .fromage("f1")
                .build();
        System.out.println(pizza);
        //Class<?> classPerson = Class.forName("org.example.design_pattern_builder.classes");


    }
}
