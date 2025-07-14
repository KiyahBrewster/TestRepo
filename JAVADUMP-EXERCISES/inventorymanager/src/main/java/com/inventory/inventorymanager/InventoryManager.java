package ui;

import model.Product;
import model.PerishableProduct;
import service.InventoryService;

import java.util.Scanner;

public class InventoryManager {
	private static final Scanner scanner = new Scanner(System.in);
	private static final InventoryService service = new InventoryService();

	public static void main(String[] args) {
		boolean running = true;

		while (running) {
			printMenu();
			System.out.print("Enter your choice: ");
			String choice = scanner.nextLine();

			switch (choice) {
				case "1" -> addProduct();
				case "2" -> service.viewProducts();
				case "3" -> searchProduct();
				case "4" -> updateProduct();
				case "5" -> deleteProduct();
				case "6" -> service.saveToFile();
				case "7" -> service.loadFromFile();
				case "8" -> running = false;
				default -> System.out.println("Invalid choice! Please try again.");
			}
		}
	}

	private static void printMenu() {
		System.out.println("\n===== Inventory Manager =====");
		System.out.println("1. Add Product");
		System.out.println("2. View Products");
		System.out.println("3. Search Product");
		System.out.println("4. Update Product");
		System.out.println("5. Delete Product");
		System.out.println("6. Save Inventory to File");
		System.out.println("7. Load Inventory from File");
		System.out.println("8. Exit");
	}

	private static void addProduct() {
		System.out.print("Is this a perishable product? (yes/no): ");
		String isPerishable = scanner.nextLine();

		System.out.print("Enter Product ID: ");
		String id = scanner.nextLine();
		System.out.print("Enter Product Name: ");
		String name = scanner.nextLine();
		System.out.print("Enter Quantity: ");
		int qty = Integer.parseInt(scanner.nextLine());
		System.out.print("Enter Price: ");
		double price = Double.parseDouble(scanner.nextLine());

		if (isPerishable.equalsIgnoreCase("yes")) {
			System.out.print("Enter Expiry Date (YYYY-MM-DD): ");
			String expiryDate = scanner.nextLine();
			service.addProduct(new PerishableProduct(id, name, qty, price, expiryDate));
		} else {
			service.addProduct(new Product(id, name, qty, price));
		}
	}

	private static void searchProduct() {
		System.out.print("Enter Product ID or Name: ");
		String query = scanner.nextLine();
		service.searchProduct(query);
	}

	private static void updateProduct() {
		System.out.print("Enter Product ID to update: ");
		String id = scanner.nextLine();
		System.out.print("Enter new quantity (or press Enter to skip): ");
		String qtyStr = scanner.nextLine();
		System.out.print("Enter new price (or press Enter to skip): ");
		String priceStr = scanner.nextLine();

		Integer qty = qtyStr.isEmpty() ? null : Integer.parseInt(qtyStr);
		Double price = priceStr.isEmpty() ? null : Double.parseDouble(priceStr);

		service.updateProduct(id, qty, price);
	}

	private static void deleteProduct() {
		System.out.print("Enter Product ID to delete: ");
		String id = scanner.nextLine();
		service.deleteProduct(id);
	}
}