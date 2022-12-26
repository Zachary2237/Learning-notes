package Cheaper1_to_8.Practice.practice10;

public class ComparableCircle extends Circle implements CompareObject{

    public ComparableCircle(double radius) {
        super(radius);
    }

    @Override
    public int compareTo(Object o) {
        if(this == o){
            return 0;
        }
        if(o instanceof ComparableCircle){
            ComparableCircle c = (ComparableCircle) o;
            //return (int)(this.getRadius() - c.getRadius());
            //方式二: 当属性radius声明为Double类型时,可以调用包装类的方法
            if(this.getRadius() > c.getRadius()){
                return 1;
            }else if (this.getRadius() < c.getRadius()){
                return -1;
            }else {
                return 0;
            }
        }else{
            //return 0;
            throw new RuntimeException("传入的数据类型不匹配");
        }
    }
}
