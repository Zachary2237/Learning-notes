package Collection.Map.java;

import org.junit.Test;

import java.util.*;

/**
 * @author wxh
 * @description
 *
 * 一.Collection.Map:双列数据,存储key-value对的数据
 *      HashMap:作为Map的主要实现类,线程不安全的,效率高,存储null的key和value
 *          LinkedHashMap:保证在遍历map元素时,可以按照添加的顺序实现遍历
 *              原因:在原有的HashMap底层结构基础上,添加了一对指针,指向前一个和后一个元素
 *              对于频繁的遍历操作,此类执行效率高于HashMap
 *      TreeMap:保证按照添加的key-value进行排序,实现排序遍历.此时考虑key的自然排序或定制排序
 *              底层使用红黑树
 *      Hashtable:作为古老的实现类,线程安全的,效率低,不能存储null的key和value
 *          Properties:常用来处理配置文件,key和value都是String类型
 *
 *
 * HashMap的底层:数组+链表(jdk7及之前)
 *              数组+链表+红黑树(jdk8)
 *
 *
 *
 * 面试题:
 * 1. HashMap的底层实现原理
 * 2. HashMap和Hashtable的异同
 * 3. CurrentHashMap与Hashtable的异同
 *
 *
 * 二.Map结构的理解
 *    Map中的key:无序的,不可重复的,使用Set存储所有的key --->key所在的类要重写equals()和hashCode() (以HashMap为例)
 *    Map中的value:无序的,可重复的,使用Collection存储所有的value --->value梭子啊的类要重写equals()
 *    一个键值对:key-value构成了一个Entry对象
 *    Map中的entry:无序的,不可重复的,使用Set存储所有的entry
 *
 * 三.HashMap的底层实现原理. 以jdk7为例(重点,要看源码)
 *    HashMap map = new HashMap();
 *    在实例化以后,底层创建了长度是16的一维数组Entry[] table.
 *    在一次put操作中:
 *    map.put(key1, value1):
 *    首先,调用key1所在类的hashCode()方法计算key1的哈希值,此哈希值经过某种算法计算后,
 *    得到在Entry数组中的存放位置.
 *    如果此位置上的数据为空,此时key1-value1添加成功. ---情况1
 *    如果此位置上的数据不为空(此位置上存在一个或多个数据(以链表形式存在)),比较key1和
 *    已经存在的一个或多个数据的哈希值
 *        如果key1的哈希值与已经存在的数据都不相同,此时key1-value1添加成功 ---情况2
 *        如果key1的哈希值与已经存在的某个数据的哈希值相同,继续比较:调用key1所在类的equals()方法
 *            如果equals()返回false:此时key1-value1添加成功 ---情况3
 *            如果equals()返回false:使用value1替换相同key的value值
 *
 *    补充:关于情况2和情况3:此时key1-value1和原来的数据以链表的方式存储
 *
 *    在不断的添加过程中,会涉及到扩容问题,默认的扩容方式:扩容为原来容量的2倍,并将原有数据复制过来(要进行哈希重算)
 *
 *
 *    jdk8的不同:
 *    1. new HashMap();底层没有创建一个长度为16的数组
 *    2. jdk8底层的数组是: Node[] 而非 Entry[]
 *    3. 首次调用put()方法时,底层创建长度为16的数组
 *    4. jdk7底层结构:数组+链表; jdk8:数组+链表+红黑树
 *       当数组的某一个索引位置上的元素以链表形式存在的数据个数 > 8 且当前数组长度 > 64
 *       此时此索引位置上的所有数据改为使用红黑树存储
 *
 *
 * 四.LinkedHashMap的底层原理
 *
 * 五.Map中定义的方法:
 *  添加、删除、修改操作：
 *  Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
 *  void putAll(Collection.Map m):将m中的所有key-value对存放到当前map中
 *  Object remove(Object key)：移除指定key的key-value对，并返回value
 *  void clear()：清空当前map中的所有数据
 *  元素查询的操作：
 *  Object get(Object key)：获取指定key对应的value
 *  boolean containsKey(Object key)：是否包含指定的key
 *  boolean containsValue(Object value)：是否包含指定的value
 *  int size()：返回map中key-value对的个数
 *  boolean isEmpty()：判断当前map是否为空
 *  boolean equals(Object obj)：判断当前map和参数对象obj是否相等
 *  元视图操作的方法：
 *  Set keySet()：返回所有key构成的Set集合
 *  Collection values()：返回所有value构成的Collection集合
 *  Set entrySet()：返回所有key-value对构成的Set集合
 *
 *
 * @create 2022-12-16 15:52
 */
public class MapTest {

    @Test
    public void test5() {
        Map map = new HashMap();
        map.put("AA", 123);
        map.put(45, 123);
        map.put("BB", 56);

        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("********");
        Collection values = map.values();
        for(Object obj : values){
            System.out.println(obj);
        }
        System.out.println("********");
        Set entrySet = map.entrySet();
//        Iterator iterator1 = entrySet.iterator();
//        while(iterator1.hasNext()){
//            Object obj = iterator1.next();
//            Collection.Map.Entry entry = (Collection.Map.Entry) obj;
//            System.out.println(entry.getKey() + "---" + entry.getValue());
//        }

        System.out.println("********");
        Iterator iterator1 = entrySet.iterator();
        while(iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
    }

    @Test
    public void test4() {
        Map map = new HashMap();
        map.put("AA", 123);
        map.put(45, 123);
        map.put("BB", 56);

        System.out.println(map.get(45));

        boolean isExist = map.containsKey("BB");
        System.out.println(isExist);
        map.clear();
        System.out.println(map.isEmpty());
        System.out.println(map.containsValue(123));

    }

    @Test
    public void test3() {
        Map map = new HashMap();
        map.put("AA", 123);
        map.put(45, 123);
        map.put("BB", 56);
        map.put("AA", 87);

        System.out.println(map);

        Map map1 = new HashMap();
        map1.put("CC", 123);
        map1.put("DD", 123);

        map.putAll(map1);

        System.out.println(map);

        Object value = map.remove("CC");
        System.out.println(value);
        System.out.println(map);

        map.clear();
        System.out.println(map.size());
    }

    @Test
    public void test1() {
        Map map = new HashMap();
        map = new Hashtable();
        map.put(null, null);
        System.out.println(map);
    }

    @Test
    public void test2(){
        Map map = new HashMap();
        map = new LinkedHashMap();
        map.put(123, "AA");
        map.put(345, "BB");
        map.put(12, "CC");

        System.out.println(map);


    }

}
