package Chapter11.List_Set;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author wxh
 * @description
 * @create 2022-12-15 17:21
 */
public class TreeSetTest{
    /**
     * 1.向TreeSet中添加的数据,要求是相同类的对象,不能添加不同类的的对象
     * 2.两种排序方式:自然排序(compareTo接口)和定制排序(Comparator)
     *
     *
     * 3.自然排序中,比较两个对象是否相同的标准为:compareTo()返回0,不再是equals()
     * 4.定制排序中,比较两个对象是否相同的标准为:compare()返回0,不再是equals()
     */

    @Test
    public void test1(){
        TreeSet set = new TreeSet();
//        set.add(123);
//        set.add(456);
//        set.add("AA");
//        set.add(new Person("tom", 22));

//        set.add(34);
//        set.add(-34);
//        set.add(43);
//        set.add(11);

        set.add(new User("Tom", 12));
        set.add(new User("Jerry", 18));
        set.add(new User("Don", 33));
        set.add(new User("Jack", 28));
        set.add(new User("Jack", 38));


        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }

    @Test
    public void test2(){
        Comparator com = new Comparator(){
            //按照年龄从小到大排列
            @Override
            public int compare(Object o1, Object o2){
                if(o1 instanceof User && o2 instanceof User){
                    User u1 = (User) o1;
                    User u2 = (User) o2;
                    return Integer.compare(u1.getAge(), u2.getAge());
                }else {
                    throw new RuntimeException("error");
                }
            }
        };

        TreeSet set = new TreeSet(com);
        set.add(new User("Tom", 12));
        set.add(new User("Jerry", 18));
        set.add(new User("Don", 33));
        set.add(new User("Jack", 28));
        set.add(new User("Jack", 38));


        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
