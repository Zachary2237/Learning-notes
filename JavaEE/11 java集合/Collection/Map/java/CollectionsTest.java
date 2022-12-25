package Collection.Map.java;

import org.junit.Test;

import java.util.*;

/**
 * @author wxh
 * @description
 *
 * Collection:操作Collection,Map的工具类
 *
 * 面试题:Collection和Collections的区别
 *
 * @create 2022-12-20 15:40
 */
public class CollectionsTest {

/**
 * Collections 是一个操作 Set、List 和 Collection.Map 等集合的工具类
 * Collections 中提供了一系列静态的方法对集合元素进行排序、查询和修改等操作，
 * 还提供了对集合对象设置不可变、对集合对象实现同步控制等方法
 * 排序操作：（均为static方法）
 * reverse(List)：反转 List 中元素的顺序
 * shuffle(List)：对 List 集合元素进行随机排序
 * sort(List)：根据元素的自然顺序对指定 List 集合元素按升序排序
 * sort(List，Comparator)：根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
 * swap(List，int， int)：将指定 list 集合中的 i 处元素和 j 处元素进行交换
 *
 * 查找、替换
 * Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
 * Object max(Collection，Comparator)：根据 Comparator 指定的顺序，返回
 * 给定集合中的最大元素
 * Object min(Collection)
 * Object min(Collection，Comparator)
 * int frequency(Collection，Object)：返回指定集合中指定元素的出现次数
 * void copy(List dest,List src)：将src中的内容复制到dest中
 * boolean replaceAll(List list，Object oldVal，Object newVal)：使用新值替换
 * List 对象的所有旧值
 *
 *
  */

    @Test
    public void test1() {
        List list = new ArrayList();
        list.add(123);
        list.add(34);
        list.add(678);
        list.add(0);
        list.add(-97);

        System.out.println(list);
//        Collections.reverse(list);
//        System.out.println(list);
//        Collections.sort(list);
//        System.out.println(list);
//
//        Collections.shuffle(list);
//        System.out.println(list);
//
//        Collections.swap(list, 2, 1);
//        System.out.println(list);

//        int frequency = Collections.frequency(list, 123);
//        System.out.println(frequency);

        //wrong!!!
//        List dest = new ArrayList();
//        Collections.copy(dest, list);

        List dest = Arrays.asList(new Object[list.size()]);
        System.out.println(dest.size());
        Collections.copy(dest, list);
        System.out.println(dest);


    }

}
