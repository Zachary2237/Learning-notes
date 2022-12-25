package Collection.List_Set;

import org.junit.Test;

import java.util.*;

/**
 * @author wxh
 * @description
 * Collection接口：单列集合，用来存储一个一个的对象
 *      List接口：存储有序的、可重复的数据 --->“动态”数组，替换原有的数组
 *          ArrayList：List接口的主要实现类；线程不安全的，效率高；底层使用Object[] elementData存储
 *          LinkedList：底层使用双向链表存储。对于频繁的插入，删除操作，使用此类效率比ArrayList效率高
 *          Vector：List接口的古老实现类；线程安全的，效率低；底层使用Object[] elementData存储
 *
 * 面试题：ArrayList,LinkedList,Vector三者的异同
 * 同：三个类都实现了List接口，存储数据的特点相同；存储有序的，可重复的数据
 * @create 2022-12-14 15:01
 */
public class ListTest{
//void add(int index, Object ele):在index位置插入ele元素
//boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
//Object get(int index):获取指定index位置的元素
//int indexOf(Object obj):返回obj在集合中首次出现的位置
//int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
//Object remove(int index):移除指定index位置的元素，并返回此元素
//Object set(int index, Object ele):设置指定index位置的元素为ele
//List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的子集合

    /**
     * 总结:常用方法
     * 增: add(Object obj)
     * 删: remove(int index)
     * 改: set(int index, Object ele)
     * 查: get(int index)
     * 插: add(int index, Object ele)
     * 长度: size()
     * 遍历: 1. Iterator迭代器
     *      2. 增强for循环
     *      3. 普通的循环
     */

    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(456);

        System.out.println(list);

        list.add(1, "Bb");
        System.out.println(list);

        List<Integer> list1 = Arrays.asList(1, 2, 3);
        list.addAll(list1);
        System.out.println(list.size());

        System.out.println(list.get(1));
    }

    @Test
    public void test2(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(456);

        System.out.println(list);

        //int indexOf(Object obj)
        int index = list.indexOf(4567);
        System.out.println(index);

        //int lastIndexOf(Object obj)
        int lastIndex = list.lastIndexOf(456);
        System.out.println(lastIndex);

        //Object remove(int index)
        Object obj = list.remove(1);
        System.out.println(obj);
        System.out.println(list);

        //Object set(int index, Object ele)
        list.set(1, "EE");
        System.out.println(list);

        //List subList(int fromIndex, int toIndex):左闭右开位置的子集合
        List subList = list.subList(0, 2);
        System.out.println(subList);
    }

    @Test
    public void test3(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(456);

        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("**********");

        for(Object obj: list){
            System.out.println(obj);
        }

        System.out.println("**********");

        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }


}
