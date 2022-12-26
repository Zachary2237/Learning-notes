package Cheaper11.collection;

import org.junit.Test;

import java.util.*;

/**
 * @author wxh
 * @description
 * @create 2022-11-14 11:21
 */
public class CollectionTest{

    @Test
    public void test1(){
        Collection coll = new ArrayList();
        //add(Object e)将元素e添加到几何coll中
        coll.add("AA");
        coll.add(123);
        coll.add("Bb");
        coll.add(new Date());

        //size()获取添加的元素的个数
        System.out.println(coll.size());

        Collection coll1 = new ArrayList();
        coll.add("CC");
        coll.add(235);
        coll.add("KK");
        //addAll(Collection coll1)将从coll1集合中的元素添加到当前集合中
        coll.addAll(coll1);
        System.out.println(coll.size());

        System.out.println(coll);
        //clear():清空集合元素
        //coll.clear();

        //isEmpty():判断当前集合是否为空
        System.out.println(coll.isEmpty());

        //contains(Object obj):判断当前集合中是否包含obj
        //contains()在判断时会调用obj对象所在类的equals()
        boolean contains = coll.contains(235);
        System.out.println(contains);

        coll.add(new Person("Jerry", 18));
        System.out.println(coll.contains(new Person("Jerry", 18)));

        //containsAll(Collection coll1):判断形参coll1中的所有元素是否都存在于当前集合中
        Collection coll2 = Arrays.asList(123, 235);
        System.out.println(coll.containsAll(coll2));

        //remove(),removeAll()

        //retainAll(Collection coll1)返回两个集合的交集,存入当前集合中
        Collection coll3 = Arrays.asList(123, 235, 789);
        coll.retainAll(coll3);
        System.out.println(coll);

        //集合 ---> 数组：toArray()
        Object[] objects = coll.toArray();
        for(int i = 0; i < objects.length; i++){
            System.out.println(objects[i]);
        }

        //数组 ---> 集合：调用Arrays类的静态方法asList()
        List<String> list = Arrays.asList(new String[]{"QQ", "!!", "BB"});
        System.out.println(list);

        //iterator():返回Iterator接口的实例，用于遍历集合元素


    }

}
