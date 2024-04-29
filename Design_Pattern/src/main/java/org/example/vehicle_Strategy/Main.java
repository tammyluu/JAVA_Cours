package org.example.vehicle_Strategy;

import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        NavigationSystem navigationSystem = new NavigationSystem(new RoadStrategy());
        navigationSystem.navigate("Tourcoing");
        navigationSystem.setNavigationStrategy(new OffroadStrategy());
        navigationSystem.navigate("Tourcoing");
        navigationSystem.setNavigationStrategy(new EconomicStrategy());
        navigationSystem.navigate("Tourcoing");
        String choice;
        do {
            System.out.println("1  RoadStrategy ");
            System.out.println("2  OffroadStrategy");
            System.out.println("3  EconomicStrategy");
            choice = sc.nextLine();
            switch (choice){
                case "1":
                   navigationSystem.proccess(new RoadStrategy());
                    break;
                case  "2":
                    navigationSystem.proccess(new OffroadStrategy());
                    break;
                case  "3":
                    navigationSystem.proccess(new EconomicStrategy());
                    break;
            }
        }while (!choice.equals("0"));
    }
}
