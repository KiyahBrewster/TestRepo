import java.util.Scanner;

public class ArrayLooping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] cities = {"Austin", "Houston", "Dallas", "San Antonio", "El Paso"};

        // 4. Print Array Elements Using a Loop
        System.out.println("Cities:");
        for (int i = 0; i < cities.length; i++) {
            System.out.println(cities[i]);
        }

        // 5. Reverse the Array
        System.out.println("\nCities in reverse:");
        for (int i = cities.length - 1; i >= 0; i--) {
            System.out.println(cities[i]);
        }

        // 6. Find a Specific Element
        System.out.print("\nEnter a city to search: ");
        String searchCity = scanner.nextLine();
        boolean found = false;

        for (int i = 0; i < cities.length; i++) {
            if (cities[i].equalsIgnoreCase(searchCity)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("City found!");
        } else {
            System.out.println("City not found!");
        }

        scanner.close();
    }
}