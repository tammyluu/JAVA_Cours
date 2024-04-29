package org.example.exception;


import java.util.Scanner;

public class InputManagement {
        private static Scanner sc = new Scanner(System.in);
        // Input a string not empty
        public static String getString(String inputMsg, String errorMsg) {
            String inputString;
            while (true) {
                System.out.print(inputMsg);
                inputString = sc.nextLine().trim().toUpperCase();
                if (inputString.isEmpty())
                    System.out.println(errorMsg);
                else
                    return inputString;
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

    public static double getADouble(String inputMsg, String errorMsg) {
        double d;
        while (true) {
            try {
                System.out.print(inputMsg);
                d = Double.parseDouble(sc.nextLine());
                return d;
            } catch (NumberFormatException e) {
                System.out.println(errorMsg);
            }
        }
    }

        public static void main(String[] args) {
            String inputString = getString("Entrez le nom d'un lieu en format chaîne de caractères: ", "Veuillez entrer un nom  valide!");
            System.out.println("Vous avez saisi :  " + inputString);


           /* double inputDouble = getADouble("Entrez un nombre réel : ", "Veuillez entrer un nombre réel valide.");
            System.out.println("Vous avez saisi : " + inputDouble);


            int inputInteger = getAnInteger("Entrez un nombre entier : ", "Veuillez entrer un nombre entier valide.");
            System.out.println("Vous avez saisi : " + inputInteger);*/
        }

    }
