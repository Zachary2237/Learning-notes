package Source.practice7;

public class CircleTest {
    public static void main(String[] args) {

        Circle c1 = new Circle();
        Circle c2 = new Circle();

        System.out.println("c1 : " + c1.getId());
        System.out.println("c2 : " + c2.getId());

        System.out.println("The num of Circle : " + Circle.getTotal());
    }
}

class Circle{

    private double radius;
    private int id;

    private static int total;//记录创建的圆的个数
    private static int init = 1001;//static声明的属性被所有对象所共享

    public Circle(){
        id = init++;
        total++;
    }

    public double findArea(){
        return 3.14 * radius * radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getTotal() {
        return total;
    }
}