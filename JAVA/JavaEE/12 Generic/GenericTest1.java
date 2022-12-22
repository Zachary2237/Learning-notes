package Generic;

import org.junit.Test;

import java.util.Collections;

/**
 * @author wxh
 * @description
 *
 * 自定义泛型结构：泛型类、泛型接口、泛型方法
 *
 * 1. 关于自定义泛型类，泛型接口
 *
 * @create 2022-12-21 19:32
 */
public class GenericTest1 {

    @Test
    public void test1() {

        //如果定义了泛型类，实例化没有指名类的泛型，则认为此泛型类型为Object类型
        //要求：如果定义了类是泛型的，建议在实例化时要指明类的泛型

//        Order order = new Order();
//        order.setOrderT(123);
//        order.setOrderT("ABC");

        Order<String> order = new Order<>("orderAA", 1001, "order:AA");
        order.setOrderT("AA: hello");

    }

    @Test
    public void test2() {
        SubOrder subOrder = new SubOrder();
        //由于子类在继承带泛型的父类时，指明了泛型类型，则实例化子类对象时，不再需要声明泛型


    }

}
