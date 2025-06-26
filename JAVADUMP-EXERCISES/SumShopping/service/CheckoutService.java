package service;

public class CheckoutService {
    public static void completeCheckout(CartService cart) {
        double total = cart.getTotalPrice();
        System.out.printf("Total due: $%.2f%n", total);
        cart.clearCart();
    }
}
