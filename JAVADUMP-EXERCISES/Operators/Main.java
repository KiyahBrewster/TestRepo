//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // ========= Part 1: Loan Payment Calculator =========
        double loanAmount = 25000.00;
        double annualInterestRate = 7.0; // Start above 6% for dynamic comparison
        int loanTermYears = 4;
        double monthlyPayment;

        // Assignment Operators
        loanAmount += 5000;               // Now 30000
        annualInterestRate -= 1.0;        // Now 6.0%
        loanTermYears = loanTermYears + 1;                  // Now 5

        // Monthly payment calculation (simple interest simulation)
        monthlyPayment = (loanAmount * (annualInterestRate / 100)) / 12;

        // Comparison & Logical Operators
        boolean isLargeLoan = false;
        boolean isPaymentHigh = false;
        boolean isAffordable = true;
        boolean isExpensive = false;

        System.out.println("=== Loan Calculator ===");
        System.out.println("Loan Amount: $" + loanAmount);
        System.out.println("Monthly Payment: $" + monthlyPayment);
        System.out.println("Loan exceeds $30,000? " + isLargeLoan);
        System.out.println("Monthly payment over $500? " + isPaymentHigh);
        System.out.println("Loan is affordable? " + isAffordable);
        System.out.println("Loan is expensive? " + isExpensive);
        System.out.println("Updated loan term (in years): " + loanTermYears);



        // ========= Part 2: Weather Conversion and Forecast =========
        double temperatureCelsius = 28.0;
        boolean isRaining = false;
        int windSpeedKmh = 25;

        // Convert Celsius to Fahrenheit
        double temperatureFahrenheit;

        // Assignment Operators
        temperatureCelsius += 5;     // Now 33
        windSpeedKmh += 5;           // Now 30
        temperatureFahrenheit = (temperatureCelsius * 9 / 5) + 32; // Recalculate

        // Comparison & Logical Operators
        boolean isHot = true;
        boolean isWindy = true;
        boolean isNiceOutside = false;
        boolean weatherWarning = false;

        System.out.println("\n=== Weather Report ===");
        System.out.println("Temperature: " + temperatureCelsius + "°C / " + temperatureFahrenheit + "°F");
        System.out.println("Is Raining: " + isRaining);
        System.out.println("Wind Speed: " + windSpeedKmh + " km/h");
        System.out.println("Is it hot? " + isHot);
        System.out.println("Is it windy? " + isWindy);
        System.out.println("Good day to go outside? " + isNiceOutside);
        System.out.println("Weather warning? " + weatherWarning);


        // ========= Part 3: Gaming - Player Score & Level System =========
        int currentXP = 1200;
        int xpToNextLevel = 1500;
        int level = 8;

        // Assignment Operators
        currentXP += 300;           // Now 1500
        xpToNextLevel -= 300;       // Now 1200
        currentXP *= 2;             // Now 3000
        xpToNextLevel -= 1200;      // Now 0

        // Comparison & Logical Operators
        boolean hasEnoughXP = true;
        boolean levelUp = true;
        boolean isPro = true;

        System.out.println("\n=== Gaming System ===");
        System.out.println("Current XP: " + currentXP);
        System.out.println("XP Needed to Level Up: " + xpToNextLevel);
        System.out.println("Level: " + level);
        System.out.println("Has enough XP to level up? " + hasEnoughXP);
        System.out.println("Level Up? " + levelUp);
        System.out.println("Is Pro Player? " + isPro);
    }
}