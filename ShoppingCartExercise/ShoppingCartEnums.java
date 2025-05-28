class ShoppingCartEnums {

    // ===== Enums =====

    enum OrderStatus {
        PENDING,
        PROCESSING,
        SHIPPED,
        DELIVERED
    }

    enum ShippingStatus {
        STANDARD,
        TWO_DAY,
        OVERNIGHT
    }

    public static void main(String[] args) {

        // ===== Print All Enum Values =====
        System.out.println("Order Status Options:");
        for (OrderStatus status : OrderStatus.values()) {
            System.out.println("- " + status);
        }

        System.out.println("\nShipping Status Options:");
        for (ShippingStatus ship : ShippingStatus.values()) {
            System.out.println("- " + ship);
        }

        // ===== Assign and Print Specific Enum Values =====
        OrderStatus myOrderStatus = OrderStatus.PROCESSING;
        ShippingStatus myShippingStatus = ShippingStatus.TWO_DAY;

        System.out.println("\nMy order is currently: " + myOrderStatus);
        System.out.println("Chosen shipping method: " + myShippingStatus);
    }
}
