import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner io = new Scanner(System.in);

        System.out.println("Welcome to the dungeon!");
        System.out.print("Do you want to enter the cave? (y/n): ");
        String enterCave = io.nextLine();

        if (enterCave.equals("y")) {
            System.out.print("Do you want to go (l)eft or (r)ight? ");
            String direction = io.nextLine();

            if (direction.equals("l")) {
                System.out.println("You have encountered a Grue.");
            } else if (direction.equals("r")) {
                System.out.println("The path is clear, you move forward.");
            } else {
                System.out.println("Invalid direction.");
            }
        } else {
            System.out.println("You chose not to enter the cave.");
        }
    }
}
