package Collection.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

/**
 * @author wxh
 * @description
 *
 * 集合元素的遍历操作，使用迭代器Iterator接口
 *
 * @create 2022-11-14 14:09
 */
public class IteratorTest{

    @Test
    public void test1(){
        Collection coll = new ArrayList();
        //add(Object e)将元素e添加到几何coll中
        coll.add("AA");
        coll.add(123);
        coll.add("Bb");
        coll.add(new Date());

        Iterator iterator = coll.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

    @Test
    public void test2(){
        Collection coll = new ArrayList();
        //add(Object e)将元素e添加到几何coll中
        coll.add("AA");
        coll.add(123);
        coll.add("Bb");
        coll.add(new Date());

        Iterator iterator = coll.iterator();

        while(iterator.hasNext()){
            Object obj = iterator.next();
            if("AA".equals(obj)){
                iterator.remove();
            }
        }


    }

}
