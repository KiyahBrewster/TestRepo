import java.util.Scanner;

public class TerminalUtils {
    private static final Scanner scanner = new Scanner(System.in);

    public static String prompt(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    public static int promptInt(String message) {
        try {
            return Integer.parseInt(prompt(message));
        } catch (NumberFormatException e) {
            System.out.println("Invalid number input.");
            return -1;
        }
    }

    public static void closeScanner() {
        scanner.close();
    }
}