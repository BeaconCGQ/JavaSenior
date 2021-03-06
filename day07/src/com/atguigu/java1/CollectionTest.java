package com.atguigu.java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
  *
  * Collection:操作Collection、Map工具类
  *
  * 面试题：Collection 和 Collections 区别:
  *   Collection：  创建集合的接口
  *   Collections： 操作集合的工具类
  *
  * @author: 86173
  * @date: 2021/4/18 11:25
  */
public class CollectionTest {
    /*
    排序操作：（均为static方法）
reverse(List)：反转 List 中元素的顺序
shuffle(List)：对 List 集合元素进行随机排序
sort(List)：根据元素的自然顺序对指定 List 集合元素按升序排序
sort(List，Comparator)：根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
swap(List，int， int)：将指定 list 集合中的 i 处元素和 j 处元素进行交换
     */

     /*
     查找、替换
Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
Object max(Collection，Comparator)：根据 Comparator 指定的顺序，返回
给定集合中的最大元素
Object min(Collection)
Object min(Collection，Comparator)
int frequency(Collection，Object)：返回指定集合中指定元素的出现次数
void copy(List dest,List src)：将src中的内容复制到dest中
boolean replaceAll(List list，Object oldVal，Object newVal)：使用新值替换List对象的所有旧值
      */

    @Test
    public void test3(){

        /*
        Collections 类中提供了多个 synchronizedXxx() 方法，该方法可使将指定集
             合包装成线程同步的集合，从而可以解决多线程并发访问集合时的线程安全问题
         */
        List list = new ArrayList();
        list.add(123);
        list.add(43);
        list.add(-56);
        list.add(0);

        List list1 = Collections.synchronizedList(list);//list1即为线程安全的List



    }
    @Test
    public void test2(){

        List list = new ArrayList();
        list.add(123);
        list.add(43);
        list.add(-56);
        list.add(0);

        //错误的:IndexOutOfBoundsException("Source does not fit in dest")
//        List dest = new ArrayList();

        //正确的
        List dest = Arrays.asList(new Object[list.size()]);
        System.out.println(dest.size());//4
        Collections.copy(dest,list);
        System.out.println(dest);

    }

     @Test
    public void test1(){

         List list = new ArrayList();
         list.add(123);
         list.add(43);
         list.add(-56);
         list.add(0);
         System.out.println(list);

         Collections.reverse(list);
         System.out.println(list);

         Collections.shuffle(list);
         System.out.println(list);

         Collections.sort(list);
         System.out.println(list);

         Collections.swap(list,1,2);
         System.out.println(list);

         int frequency = Collections.frequency(list, 0);
         System.out.println(frequency);


     }
}
