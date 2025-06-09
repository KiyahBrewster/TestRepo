import java.util.Scanner;

public class UserRegistration {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int age = 0;
        String email = null;
        int pin = 0;

        try {
            // AGE input with loop for retry
            while (true) {
                try {
                    System.out.print("Enter your age: ");
                    age = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid age. Please enter a valid number.");
                }
            }

            // EMAIL input
            System.out.print("Enter your email: ");
            email = scanner.nextLine();
            if (email == null || email.trim().isEmpty()) {
                throw new NullPointerException("Email cannot be null or empty.");
            }

            // PIN input with validation and retry
            while (true) {
                try {
                    System.out.print("Enter your 4-digit PIN: ");
                    String pinInput = scanner.nextLine();
                    if (pinInput.length() != 4 || !pinInput.matches("\\d{4}")) {
                        throw new IllegalArgumentException("PIN must be exactly 4 digits.");
                    }
                    pin = Integer.parseInt(pinInput);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("PIN must be numeric.");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            // SUCCESS
            System.out.println("\nRegistration Successful!");
            System.out.println("Age: " + age);
            System.out.println("Email: " + email);
            System.out.println("PIN: " + pin);

        } catch (NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Registration Attempt Complete!");
            scanner.close();
        }
    }
}