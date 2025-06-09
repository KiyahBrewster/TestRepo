// MethodsExercise.java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        printWelcomeMessage();
        System.out.println("Sum: " + sum(5, 10));
        System.out.println("Fahrenheit: " + convertToFahrenheit(25));
        System.out.println("Is 4 even? " + isEven(4));
        printMultipleTimes("Java!", 3);
        System.out.println("Max of (7, 15, 10): " + findMax(7, 15, 10));
        System.out.println("Factorial of 5: " + factorial(5));
        greet("Alice");
        greet("Bob", 30);
        System.out.println("Vowels in 'hello world': " + countVowels("hello world"));
        System.out.println("Calculator result: " + calculator(10, 2, '*'));
        System.out.println("Is 'racecar' a palindrome? " + isPalindrome("racecar"));
    }

    // Task 1
    public static void printWelcomeMessage() {
        System.out.println("Welcome to the Java Methods Exercise!");
    }

    // Task 2
    public static int sum(int a, int b) {
        return a + b;
    }

    // Task 3
    public static double convertToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    // Task 4
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    // Task 5
    public static void printMultipleTimes(String text, int times) {
        for (int i = 0; i < times; i++) {
            System.out.println(text);
        }
    }

    // Task 6
    public static int findMax(int a, int b, int c) {
        int max = a;
        if (b > max) max = b;
        if (c > max) max = c;
        return max;
    }

    // Task 7
    public static int factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }

    // Task 8
    public static void greet(String name) {
        System.out.println("Hello, " + name + "!");
    }

    public static void greet(String name, int age) {
        System.out.println("Hello, " + name + "! You are " + age + " years old.");
    }

    // Task 9
    public static int countVowels(String text) {
        int count = 0;
        for (char c : text.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    // Task 10
    public static double calculator(int num1, int num2, char operator) {
        return switch (operator) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> num2 != 0 ? (double) num1 / num2 : Double.NaN;
            default -> 0;
        };
    }

    // Bonus
    public static boolean isPalindrome(String text) {
        String reversed = new StringBuilder(text).reverse().toString();
        return text.equalsIgnoreCase(reversed);
    }
}