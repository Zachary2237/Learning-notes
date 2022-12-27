package Chapter9;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author wxh
 * @description
 *
 * 1. java中的对象, 正常情况下, 只能进行比基奥: == or !=, 不能使用> , <
 *    但是在开发中, 又需要对多个对象进行排序, 即需要比较对象的大小---使用接口
 *    Comparable or Comparator
 *
 * 2. Comparable接口
 *    > 像String, 包装类等实现了Comparable接口, 重写了compareTo()方法, 给出了比较两个对象大小的方式
 *    > 像String, 包装类重写compareTo()方法后, 进行了从小到大的排序
 *    > 重写compareTo()的规则:
 *      - 如果当前对象this大于形参对象obj，则返回正整数，如果当前对象this小于形参对象obj，则返回
 *        负整数，如果当前对象this等于形参对象obj，则返回零。
 *
 * @create 2022-10-23 10:43
 */
public class CompareTest{
    @Test
    public void test1(){

        String[] arr = new String[]{"AA", "CC", "KK", "BB", "DD", "GG"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

    }

}
