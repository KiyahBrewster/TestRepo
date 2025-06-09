import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        runTests();
        promptUser();
    }

    private static String selectDrink(String choice) {
        System.out.println("Received input: " + choice); // Debug print
        if (choice == null) {
            return "Invalid selection";
        }

        String normalized = choice.toLowerCase();
        System.out.println("Lowercased input: " + normalized); // Debug print

        String result;
        switch (normalized) {
            case "water":
                result = "You selected Water";
                break;
            case "soda":
                result = "You selected Soda";
                break;
            case "juice":
                result = "You selected Juice";
                break;
            default:
                result = "Invalid selection";
                System.out.println("Invalid input detected.");
                break;
        }

        System.out.println("Selected: " + result); // Debug print
        return result;
    }

    private static void runTests() {
        String[] inputs = {"water", "soda", "juice", "WATER", "Tea", ""};
        String[] expectedOutputs = {
                "You selected Water",
                "You selected Soda",
                "You selected Juice",
                "You selected Water",
                "Invalid selection",
                "Invalid selection"
        };

        for (int i = 0; i < inputs.length; i++) {
            String input = inputs[i];
            String expected = expectedOutputs[i];
            System.out.print("Testing with " + (input.isEmpty() ? "Empty Input" : input) + "... ");
            String actual = selectDrink(input);
            if (expected.equals(actual)) {
                System.out.println("Passed!");
            } else {
                System.out.println("FAIL: Expected '" + expected + "', got '" + actual + "'");
            }
        }
    }

    private static void promptUser() {
        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            System.out.print("Enter a drink (water, soda, juice): ");
            input = scanner.nextLine();
            String result = selectDrink(input);
            System.out.println(result);
            if (!result.equals("Invalid selection")) {
                break;
            }
        }
        scanner.close();
    }
}
