//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    enum OrderStatus {
        ORDERED,
        WAREHOUSE,
        SHIPPED,
        DELIVERED,
        RETURNED
    }

    enum TrafficLight{
        RED,
        YELLOW,
        GREEN,
    }
     enum GameStatus {
        WIN,
         LOSS,
         TIE,
     }



    public static void main(String[] args) {
        TrafficLight[] indexes = TrafficLight.values();

        TrafficLight light = indexes[2];

        System.out.println(light);

// Label for number - status codes
        // order status, 1 ordered, 2 warehouse, 3 shipped, 4 delivered, 5 returned

      // OrderStatus status = OrderStatus.WAREHOUSE;


     //  System.out.println(OrderStatus.DELIVERED);
     //  System.out.println(OrderStatus.DELIVERED.ordinal());

       //get a collection of all the enum values
     //   GameStatus[] statuses = GameStatus.values();
        //assign an enum

       //if(status == OrderStatus.WAREHOUSE) {
           // do stuff for warehouse processing
       // }

    }
}