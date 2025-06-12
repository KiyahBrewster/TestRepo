public class Main {
    public static void main(String[] args) {
        LockerService service = new LockerService(10);

        while (true) {
            displayMenu(service.isFull());
            String input = TerminalUtils.prompt("Enter your choice: ");

            switch (input) {
                case "1":
                    if (service.isFull()) {
                        System.out.println("No lockers available.");
                    } else {
                        Locker locker = service.rentLocker();
                        System.out.printf("Locker #%d rented. Your PIN is: %s\n", locker.getNumber(), locker.getPin());
                    }
                    break;
                case "2":
                    accessLocker(service);
                    break;
                case "3":
                    releaseLocker(service);
                    break;
                default:
                    System.out.println("Exiting program.");
                    TerminalUtils.closeScanner();
                    return;
            }
        }
    }

    static void displayMenu(boolean isFull) {
        System.out.println("\nWhat would you like to do next?");
        if (!isFull) System.out.println("1. Rent a Locker");
        System.out.println("2. Access a Locker");
        System.out.println("3. Release a Locker");
        System.out.println("---");
    }

    static void accessLocker(LockerService service) {
        int number = TerminalUtils.promptInt("Enter locker number: ");
        Locker locker = service.getLocker(number);
        if (locker == null || locker.isAvailable()) {
            System.out.println("Invalid or unrented locker.");
            return;
        }

        String pin = TerminalUtils.prompt("Enter PIN: ");
        if (locker.verifyPin(pin)) {
            System.out.println("Access granted. You may use your phone.");
        } else {
            System.out.println("Access denied. Incorrect PIN.");
        }
    }

    static void releaseLocker(LockerService service) {
        int number = TerminalUtils.promptInt("Enter locker number: ");
        Locker locker = service.getLocker(number);
        if (locker == null || locker.isAvailable()) {
            System.out.println("Invalid or unrented locker.");
            return;
        }

        String pin = TerminalUtils.prompt("Enter PIN: ");
        if (locker.verifyPin(pin)) {
            String confirm = TerminalUtils.prompt("Are you sure you want to release the locker? (yes/no): ");
            if (confirm.equalsIgnoreCase("yes")) {
                locker.release();
                System.out.println("Locker released.");
            } else {
                System.out.println("Locker not released.");
            }
        } else {
            System.out.println("Incorrect PIN.");
        }
    }
}