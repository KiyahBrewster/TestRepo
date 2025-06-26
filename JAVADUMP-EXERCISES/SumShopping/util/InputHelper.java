package util;

import java.util.Scanner;

public class InputHelper {
    private static final Scanner scanner = new Scanner(System.in);

    public static String prompt(String message) {
        System.out.print(message);
        return scanner.nextLine().trim();
    }

    public static int promptInt(String message) {
        while (true) {
            try {
                return Integer.parseInt(prompt(message));
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    public static double promptDouble(String message) {
        while (true) {
            try {
                return Double.parseDouble(prompt(message));
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid price.");
            }
        }
    }
}
