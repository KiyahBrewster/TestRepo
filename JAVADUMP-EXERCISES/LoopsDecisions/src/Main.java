import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // 1. Count Up! (Even numbers)
        System.out.println("Even numbers from 1 to 100:");
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) System.out.print(i + " ");
        }
        System.out.println("\n");

        // 2. Countdown Timer
        System.out.print("Enter a starting number for countdown: ");
        int countdown = Integer.parseInt(scanner.nextLine());
        while (countdown >= 0) {
            System.out.println(countdown);
            countdown--;
        }
        System.out.println("Blast off!\n");

        // 3. Guess the Number (1–50)
        int number = random.nextInt(50) + 1;
        int guess;
        do {
            System.out.print("Guess a number between 1 and 50: ");
            guess = Integer.parseInt(scanner.nextLine());
        } while (guess != number);
        System.out.println("Correct!\n");

        // 4. Multiplication Table
        System.out.print("Enter a number for multiplication table: ");
        int num = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d x %d = %d\n", num, i, num * i);
        }
        System.out.println();

        // 5. Password Validator
        String password;
        do {
            System.out.print("Enter the password: ");
            password = scanner.nextLine();
        } while (!password.equals("letmein"));
        System.out.println("Access granted.\n");

        // 6. First Vowel Finder
        System.out.print("Enter a word: ");
        String word = scanner.nextLine();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if ("aeiouAEIOU".indexOf(c) != -1) {
                System.out.println("First vowel at position: " + i);
                break;
            }
        }
        System.out.println();

        // 7. Simple ATM System
        int balance = 500;
        int option;
        do {
            System.out.println("1. Withdraw\n2. Deposit\n3. Check Balance\n4. Exit");
            System.out.print("Choose an option: ");
            option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1:
                    System.out.print("Withdraw amount: ");
                    int withdraw = Integer.parseInt(scanner.nextLine());
                    if (withdraw <= balance) {
                        balance -= withdraw;
                        System.out.printf("New balance: $%d\n", balance);
                    } else {
                        System.out.println("Insufficient funds.");
                    }
                    break;
                case 2:
                    System.out.print("Deposit amount: ");
                    int deposit = Integer.parseInt(scanner.nextLine());
                    balance += deposit;
                    System.out.printf("New balance: $%d\n", balance);
                    break;
                case 3:
                    System.out.printf("Current balance: $%d\n", balance);
                    break;
                case 4:
                    System.out.println("Exiting ATM...\n");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (option != 4);

        // 8. FizzBuzz
        for (int i = 1; i <= 100; i++) {
            if (i % 15 == 0) System.out.println("FizzBuzz");
            else if (i % 3 == 0) System.out.println("Fizz");
            else if (i % 5 == 0) System.out.println("Buzz");
            else System.out.println(i);
        }
        System.out.println();

        // 9. Reverse a String
        System.out.print("Enter a word to reverse: ");
        String revWord = scanner.nextLine();
        for (int i = revWord.length() - 1; i >= 0; i--) {
            System.out.print(revWord.charAt(i));
        }
        System.out.println("\n");

        // 10. Prime Number Checker
        System.out.print("Enter a number to check if prime: ");
        int check = Integer.parseInt(scanner.nextLine());
        if (isPrime(check)) {
            System.out.println("Prime number.");
        } else {
            System.out.println("Not prime.");
        }
        System.out.println();

        // 11. Word Counter
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();
        String[] words = sentence.split(" ");
        System.out.println("Word count: " + words.length + "\n");

        // 12. Skip Negative Numbers
        int input;
        do {
            System.out.print("Enter number (0 to stop): ");
            input = Integer.parseInt(scanner.nextLine());
            if (input < 0) continue;
            System.out.println("You entered: " + input);
        } while (input != 0);
        System.out.println();

        // 13. First Prime in Range
        System.out.print("Enter start of range: ");
        int start = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter end of range: ");
        int end = Integer.parseInt(scanner.nextLine());
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                System.out.println("First prime: " + i);
                break;
            }
        }
        System.out.println();

        // 14. Fixed Infinite Loop
        int i = 0;
        while (i < 10) {
            System.out.println(i);
            i++;
        }
        System.out.println();

        // 15. Even Number Checker
        int even;
        do {
            System.out.print("Enter an even number: ");
            even = Integer.parseInt(scanner.nextLine());
        } while (even % 2 != 0);
        System.out.println("You entered an even number.\n");

        // 16. Bank Withdrawal System
        int bankBalance = 1000;
        while (bankBalance > 0) {
            System.out.printf("Balance: $%d\n", bankBalance);
            System.out.print("Withdraw amount: ");
            int amt = Integer.parseInt(scanner.nextLine());
            if (amt > bankBalance) {
                System.out.println("Transaction denied.");
            } else {
                bankBalance -= amt;
            }
        }
        System.out.println("Account is empty.\n");

        // 17. Longest Word
        System.out.print("Enter a sentence: ");
        String line = scanner.nextLine();
        String[] allWords = line.split(" ");
        String longest = "";
        for (String w : allWords) {
            if (w.length() > longest.length()) longest = w;
        }
        System.out.println("Longest word: " + longest + "\n");

        // 18. Number Reversal
        System.out.print("Enter a number to reverse: ");
        int original = Integer.parseInt(scanner.nextLine());
        int reversed = 0;
        while (original != 0) {
            reversed = reversed * 10 + (original % 10);
            original /= 10;
        }
        System.out.println("Reversed: " + reversed + "\n");

        // 19. Guess the Word
        String[] list = {"apple", "banana", "cherry"};
        String secret = list[random.nextInt(list.length)];
        String guessWord;
        while (true) {
            System.out.print("Guess the word: ");
            guessWord = scanner.nextLine();
            if (guessWord.equals(secret)) {
                System.out.println("Correct!");
                break;
            } else if (secret.contains(guessWord)) {
                System.out.println("You're close!");
            }
        }
    }

    // Reusable prime checker method
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}