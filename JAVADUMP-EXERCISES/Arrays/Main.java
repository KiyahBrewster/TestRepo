// ArrayExercises.java (Full Version with All Exercises)
import java.util.*;

public class Main {
    public static void main(String[] args) {
        part1();
        part2();
        part3();
        part4();
        bonus();
        finalSort();
        extraMenu();
    }

    // Part 1: Basic Array Operations
    public static void part1() {
        String[] cities = {"Austin", "Houston", "Dallas", "San Antonio", "El Paso"};

        System.out.println("\nPart 1 - Original Cities:");
        for (int i = 0; i < cities.length; i++) {
            System.out.println("City " + (i + 1) + ": " + cities[i]);
        }

        cities[2] = "Fort Worth";
        System.out.println("\nUpdated Cities:");
        for (String city : cities) {
            System.out.println(city);
        }

        System.out.println("Total number of cities: " + cities.length);
    }

    // Part 2: Iterating Over Arrays
    public static void part2() {
        Scanner scanner = new Scanner(System.in);
        String[] cities = {"Austin", "Houston", "Fort Worth", "San Antonio", "El Paso"};

        System.out.println("\nPart 2 - Iterating Cities:");
        for (String city : cities) {
            System.out.println(city);
        }

        System.out.println("\nCities in reverse:");
        for (int i = cities.length - 1; i >= 0; i--) {
            System.out.println(cities[i]);
        }

        System.out.print("\nEnter a city to search: ");
        String searchCity = scanner.nextLine();
        boolean found = false;
        for (String city : cities) {
            if (city.equalsIgnoreCase(searchCity)) {
                found = true;
                break;
            }
        }
        System.out.println(found ? "City found!" : "City not found!");
    }

    // Part 3: Numeric Arrays & Calculations
    public static void part3() {
        int[] scores = {85, 92, 78, 96, 70};

        int sum = 0;
        int max = scores[0];
        int min = scores[0];

        for (int score : scores) {
            sum += score;
            if (score > max) max = score;
            if (score < min) min = score;
        }

        double average = (double) sum / scores.length;

        System.out.println("\nPart 3 - Test Scores:");
        System.out.println("Sum: " + sum);
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
        System.out.println("Average: " + average);
    }

    // Part 4: Advanced Challenges
    public static void part4() {
        int[] nums = {1, 2, 3, 4, 5};

        // Count occurrences of 3
        int[] randomNums = {3, 1, 3, 5, 2, 3, 4, 5, 1, 3};
        int count = 0;
        for (int num : randomNums) {
            if (num == 3) count++;
        }
        System.out.println("\nPart 4 - Number 3 appears: " + count + " times");

        // Shift left
        int first = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            nums[i] = nums[i + 1];
        }
        nums[nums.length - 1] = first;
        System.out.println("Shifted Array:");
        for (int n : nums) {
            System.out.print(n + " ");
        }

        // Check for duplicates
        String[] students = {"Amy", "Bob", "Cara", "Dan", "Amy", "Eli"};
        boolean duplicates = false;
        for (int i = 0; i < students.length; i++) {
            for (int j = i + 1; j < students.length; j++) {
                if (students[i].equals(students[j])) {
                    duplicates = true;
                    break;
                }
            }
        }
        System.out.println("\nDuplicates found? " + duplicates);
    }

    // Bonus: Mini Address Book
    public static void bonus() {
        Scanner scanner = new Scanner(System.in);
        String[] names = {"Alice", "Bob", "Charlie"};
        String[] phones = {"123-456", "987-654", "555-1212"};
        String[] emails = {"alice@mail.com", "bob@mail.com", "charlie@mail.com"};

        System.out.print("\nEnter a name to search: ");
        String nameInput = scanner.nextLine();
        boolean found = false;

        for (int i = 0; i < names.length; i++) {
            if (names[i].equalsIgnoreCase(nameInput)) {
                System.out.println("Phone: " + phones[i]);
                System.out.println("Email: " + emails[i]);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Contact not found.");
        }
    }

    // Final Challenge: Sorting Arrays
    public static void finalSort() {
        String[] fruits = {"Banana", "Apple", "Elderberry", "Cherry", "Date"};
        int[] nums = {9, 2, 5, 1, 7, 3, 4, 6, 8, 0};

        Arrays.sort(fruits);
        Arrays.sort(nums);

        System.out.println("\nSorted Fruits:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        System.out.println("\nSorted Numbers:");
        for (int n : nums) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    // Extra: Interactive Menu
    public static void extraMenu() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> cityList = new ArrayList<>(Arrays.asList("Austin", "Houston", "Dallas"));
        boolean running = true;

        while (running) {
            System.out.println("\nCity Menu:");
            System.out.println("1. Add a city");
            System.out.println("2. Remove a city");
            System.out.println("3. Search for a city");
            System.out.println("4. Print all cities");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter city to add: ");
                    String newCity = scanner.nextLine();
                    cityList.add(newCity);
                }
                case 2 -> {
                    System.out.print("Enter city to remove: ");
                    String removeCity = scanner.nextLine();
                    if (cityList.remove(removeCity)) {
                        System.out.println("Removed.");
                    } else {
                        System.out.println("City not found.");
                    }
                }
                case 3 -> {
                    System.out.print("Enter city to search: ");
                    String searchCity = scanner.nextLine();
                    if (cityList.contains(searchCity)) {
                        System.out.println("City found!");
                    } else {
                        System.out.println("City not found.");
                    }
                }
                case 4 -> {
                    System.out.println("Cities:");
                    for (String city : cityList) {
                        System.out.println(city);
                    }
                }
                case 5 -> {
                    System.out.println("Exiting...");
                    running = false;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}