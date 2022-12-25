package Source.practice1;

class Circle{
    private double radius;
    public Circle(){
        radius = 1;
    }

    void setRadius(double radius){
        this.radius = radius;
    }

    double getRadius(){
        return radius;
    }

    double findArea(){
        double a = 3.14 * radius * radius;
        return a;
    }
}

class Cylinder extends Circle{
    private double length;
    public Cylinder(){
        length = 1;
    }

    void setLength(double length){
        this.length = length;
    }

    double getLength(){
        return length;
    }

    double findVolume(){
        double v = findArea() * length;
        return v;
    }
}

public class CylinderTest {
    public static void main(String[] args) {
        Cylinder cir = new Cylinder();
        cir.setRadius(1);
        cir.setLength(2);

        System.out.println("Area = " + cir.findArea());
        System.out.println("Volume = " + cir.findVolume());
    }
}
