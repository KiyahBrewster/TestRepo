import java.util.Scanner;
import java.util.Random;

public class Main {

    static final int TOTAL_LOCKERS = 10;
    static String[] lockers = new String[TOTAL_LOCKERS];
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    rentLocker();
                    break;
                case "2":
                    accessLocker();
                    break;
                case "3":
                    releaseLocker();
                    break;
                default:
                    System.out.println("Exiting program. Goodbye!");
                    scanner.close();
                    return;
            }
        }
    }

    static void displayMenu() {
        System.out.println("\nWhat would you like to do next?");
        if (!isFull()) System.out.println("1. Rent a Locker");
        System.out.println("2. Access a Locker");
        System.out.println("3. Release a Locker");
        System.out.println("---");
        System.out.print("Enter your choice: ");
    }

    static void rentLocker() {
        if (isFull()) {
            System.out.println("No lockers available.");
            return;
        }

        int lockerNumber = getNextAvailableLocker();
        String pin = generatePin();

        lockers[lockerNumber] = pin;
        System.out.printf("Locker #%d rented. Your PIN is: %s\n", lockerNumber, pin);
    }

    static void accessLocker() {
        int locker = promptLockerNumber();
        if (isValidLocker(locker)) return;

        String enteredPin = prompt("Enter PIN: ");
        if (lockers[locker] != null && lockers[locker].equals(enteredPin)) {
            System.out.println("Access granted. You may use your phone.");
        } else {
            System.out.println("Access denied. Incorrect PIN.");
        }
    }

    static void releaseLocker() {
        int locker = promptLockerNumber();
        if (isValidLocker(locker)) return;

        String enteredPin = prompt("Enter PIN: ");
        if (lockers[locker] != null && lockers[locker].equals(enteredPin)) {
            String confirm = prompt("Are you sure you want to release the locker? (yes/no): ");
            if (confirm.equalsIgnoreCase("yes")) {
                lockers[locker] = null;
                System.out.println("Locker released.");
            } else {
                System.out.println("Locker not released.");
            }
        } else {
            System.out.println("Incorrect PIN or invalid locker.");
        }
    }

    static int promptLockerNumber() {
        try {
            return Integer.parseInt(prompt("Enter locker number: "));
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return -1;
        }
    }

    static boolean isValidLocker(int locker) {
        if (locker < 0 || locker >= TOTAL_LOCKERS) {
            System.out.println("Invalid locker number.");
            return true;
        }
        if (lockers[locker] == null) {
            System.out.println("This locker is currently not rented.");
            return true;
        }
        return false;
    }

    static String prompt(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    static String generatePin() {
        int number = random.nextInt(10000);
        return String.format("%04d", number); // ensures leading zeros
    }

    static boolean isFull() {
        for (String pin : lockers) {
            if (pin == null) return false;
        }
        return true;
    }

    static int getNextAvailableLocker() {
        for (int i = 0; i < lockers.length; i++) {
            if (lockers[i] == null) return i;
        }
        return -1; // should never happen if isFull() is checked
    }
}