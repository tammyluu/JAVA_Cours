package org.example.exception;


import java.util.Scanner;

public class InputManagement {
        private static Scanner sc = new Scanner(System.in);
        // Input a string not empty
        public static String getString(String inputMsg, String errorMsg) {
            String name;
            while (true) {
                System.out.print(inputMsg);
                name = sc.nextLine().trim().toUpperCase();
                if (name.isEmpty())
                    System.out.println(errorMsg);
                else
                    return name;
            }
        }
        public static int getAnInteger(String inputMsg, String errorMsg) {
            int n;
            while (true) {
                try {
                    System.out.print(inputMsg);
                    n = Integer.parseInt(sc.nextLine());
                    return n;
                } catch (Exception e) {
                    System.out.println(errorMsg);
                }
            }
        }

        public static void main(String[] args) {
            String name = getString("Entrez le nom d'un lieu: ", "Nom de lieu est obligatoire!!");
            System.out.println(" lieu " + name);
        }

    }
