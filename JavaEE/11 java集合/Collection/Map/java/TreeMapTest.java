package Collection.Map.java;

import org.junit.Test;

import java.util.*;

/**
 * @author wxh
 * @description
 * @create 2022-12-20 11:20
 */
public class TreeMapTest {

    //向TreeMap中添加key-value,要求key必须是由同一个类创建的对象
    //因为要按照key进行排序:自然排序,定制排序

    @Test
    public void test1(){
        TreeMap map = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof User && o2 instanceof User) {
                    User u1 = (User) o1;
                    User u2 = (User) o2;
                    return Integer.compare(u1.getAge(), u2.getAge());
                }else {
                    throw new RuntimeException("error!");
                }
            }
        });
        User u1 = new User("Tom", 12);
        User u2 = new User("Jerry", 15);
        User u3= new User("Jack", 28);
        User u4 = new User("Harry", 49);

        map.put(u1, 98);
        map.put(u2, 69);
        map.put(u3, 88);
        map.put(u4, 80);

        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

}
