package Source.practice5;

public class Test {
    public static void main(String[] args) {
        Circle cir1 = new Circle(1.0, "black", 2.0);
        Circle cir2 = new Circle(1.0, "white", 2.0);

        System.out.println(cir1.getColor().equals(cir2.getColor()));
        System.out.println(cir1.equals(cir2));
        System.out.println(cir1.toString());
        System.out.println(cir2.toString());

        System.out.println(cir1);
    }
}
