package Chapter12;

import org.junit.Test;

import java.util.*;

/**
 * @author wxh
 * @description
 *
 * 泛型的使用
 * 1. jdk5.0新增的特性
 *
 * 2. 在集合中使用泛型
 *    1）集合接口或集合类在jdk5.0时都修改为带泛型的结构
 *    2）在实例化集合类时，可以指名具体的泛型类型
 *    3）指名完以后，在集合类或接口中凡是定义类或者接口时，内部结构使用到的类的泛型的位置，
 *       都指定为实例化的泛型类型。
 *       如： add(E e) ---> 实例化以后： add(Integer e)
 *    4）注意：泛型的类型必须是类，不能是基本数据类型，需要用到基本数据类型的位置，用包装类替换
 *    5）如果实例化时，没有指名泛型的类型，默认类型为java.lang.Object类型
 *
 * 3. 如何自定义泛型结构：泛型类、泛型接口、泛型方法
 *
 *
 * @create 2022-12-21 16:00
 */
public class GenericTest {

    @Test
    public void test1() {

        ArrayList list = new ArrayList();
        list.add(78);
        list.add(67);
        list.add(99);
        list.add(65);

        //问题一：类型不安全
//        list.add("Tom");

        for(Object score : list) {
            //问题二：强转时，可能出现ClassCastException
            int stuScore =  (Integer) score;
            System.out.println(stuScore);
        }

    }

    @Test
    public void test2() {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(78);
        list.add(98);
        list.add(45);
//        方式一
//        for(Integer score : list) {
//            //避免了强转操作
//            int stuScore = score;
//            System.out.println(stuScore);
//
//        }

//        方式二：
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            int stuScore = iterator.next();
            System.out.println(stuScore);
        }

    }

    @Test
    public void test3() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Tom", 97);
        map.put("Jack", 98);
        map.put("Jeason", 87);

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Integer> e = iterator.next();
            String key = e.getKey();
            Integer value = e.getValue();

        }
    }

}
