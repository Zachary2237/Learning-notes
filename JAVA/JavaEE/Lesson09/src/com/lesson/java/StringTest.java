package com.lesson.java;

/**
 * @author wxh
 * @description String的使用
 *
 * 1. String: 字符串, 使用 " " 引起来表示
 * 2. String声明为final的, 不能被继承
 * 3. String实现了Serializable接口, 表示字符串支持序列化
 *          实现了Comparable接口, 表示String可以比较大小
 * 4. String内部定义了final char[] value, 用于存储字符串数据
 * 5. String: 代表不可变的字符序列, 简称不可变性
 *      体现: > 当对字符串重新赋值时, 需要重写指定内存区域赋值, 不能使用原有的value进行赋值
 *            > 当对现有字符串进行连接操作时, 也需要重新指定内存区域赋值, 不能使用原有value赋值
 *            > 当调用String的replace()方法修改字符或字符串时, 也需要重新指定内存区域
 * 6. 通过字面量的方式(区别于new)给一个字符串赋值, 此时的字符串值声明在字符串常量池中
 * 7. 字符串常量池中不会存储相同内容的字符串
 *
 *
 * String的实例化方式:
 * > 通过字面量定义的方式
 * > 通过new + 构造器的方式
 *
 * @create 2022-10-22 20:53
 */
public class StringTest{

    public void test1(){
        String s1 = "abc";
        String s2 = "abc";

        s1 = "hello";

        String s = s1.replace("c", "a");


    }

}
