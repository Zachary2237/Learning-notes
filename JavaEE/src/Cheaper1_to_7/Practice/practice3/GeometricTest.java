package Cheaper1_to_7.Practice.practice3;

public class GeometricTest {
    public boolean equalsArea(GeometricObject o1, GeometricObject o2){
        return o1.findArea() == o2.findArea();
    }

    public void displayGeometricObject(GeometricObject o){
        System.out.println("Area = " + o.findArea());
    }

    public static void main(String[] args) {
        GeometricTest test = new GeometricTest();

        Circle c1 = new Circle("white", 2.3, 1.0);
        test.displayGeometricObject(c1);
        Circle c2 = new Circle("black", 3.3, 1.0);
        test.displayGeometricObject(c2);
        boolean isequals = test.equalsArea(c1, c2);
        System.out.println("c1和c2面积是否相等," + isequals);

        MyRectangle rec1 = new MyRectangle("green", 3.0, 4.0, 1.0);
        test.displayGeometricObject(rec1);
        MyRectangle rec2 = new MyRectangle("blue", 4.0, 3.0, 1.0);
        test.displayGeometricObject(rec2);

        if(test.equalsArea(rec1, rec2)){
            System.out.println("Equal!");
        }else{
            System.out.println("No Equal!");
        }
    }

}
