package Source.practice4;

public class OrderTest {
    public static void main(String[] args) {
        Order order1 = new Order(1001, "AA");
        Order order2 = new Order(1001, "BB");

        System.out.println(order1.equals(order2));

        Order order3 = new Order(1001, "BB");
        System.out.println(order2.equals(order3));
    }
}
