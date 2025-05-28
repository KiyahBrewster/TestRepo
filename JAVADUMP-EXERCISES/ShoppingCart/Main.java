//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // === Product Information ===
        int productId = 1;
        int productCategory = 2;
        double productCost = 2.56;
        double productPrice = 4.99;
        int productQuantity = 78;

        // === 1. Total Cost Calculation ===
        double totalCost = productCost * productQuantity;
        System.out.println("Total cost of inventory: $" + totalCost);

        // === 2. Profit Margin (per item) ===
        double profitMargin = productPrice - productCost;
        System.out.println("Profit margin per item: $" + profitMargin);

        // === 3. Total Potential Profit ===
        double totalPotentialProfit = profitMargin * productQuantity;
        System.out.println("Total potential profit: $" + totalPotentialProfit);
    }
}
