public class ObjectPractice {
    public static void main(String[] args) {

        // Part 1: Car Dealership
        Car car1 = new Car("Honda", "Civic", 2021);
        Car car2 = new Car("Chevrolet", "Camaro", 2023);
        car1.displayInfo();
        car2.displayInfo();

        System.out.println();

        // Part 2: Book Library
        Book book1 = new Book("Dune", "Frank Herbert");
        book1.displayStatus();
        System.out.println("Borrowing the book...");
        book1.borrowBook();
        book1.displayStatus();

        System.out.println();

        // Part 3: Bank Account Reference
        BankAccount acc1 = new BankAccount("Malik", 850.0);
        BankAccount acc2 = acc1; // same object reference
        acc1.displayBalance();
        System.out.println("Depositing $300 to acc2...");
        acc2.deposit(300);
        acc1.displayBalance();

        System.out.println();

        // Part 4: Employee Static Count
        new Employee("Leila");
        new Employee("Carlos");
        new Employee("Amina");
        System.out.println("Total Employees: " + Employee.getTotalEmployees());
    }
}