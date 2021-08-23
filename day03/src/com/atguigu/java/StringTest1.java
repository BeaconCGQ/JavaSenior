package com.atguigu.java;


import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * 涉及到String类与其他结构转换
 *
 * @author: 86173
 * @date: 2021/4/11 17:09
 */
public class StringTest1 {
    /*
      复习：String --> 基本数据类型、包装类 :调用包装类的静态方法 parseXxx(str)
           基本数据类型、包装类 --> String ：调用String重载的ValueOf(xxx)
     */
    @Test
    public void test1() {
        String str1 = "123";
        int num = Integer.parseInt(str1);

        String str2 = String.valueOf(num);//"123"
        String str3 = num + "";

        System.out.println(str1 == str3);
    }

    /*
       String --> char[] :调用String的toCharArray()
       char[] --> String:调用String构造器

     */
    @Test
    public void test2() {

        String str1 = "abc123";
        char[] charArray = str1.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            System.out.print(charArray[i] + " ");

        }

        char[] arr = new char[]{'h', 'e', 'l', 'l', 'o'};
        String str2 = new String(arr);
        System.out.println(str2);
    }

    /*
       String --> byte[] :调用String的getBytes()
       byte[] --> String :调用String构造器
       编码：字符串-->字节
       解码：字节-->字符串

       说明：解码时要求解码使用的字符集必须与编码一致，否则会出现乱码
     */
    @Test
    public void test3() throws UnsupportedEncodingException {

        String str1 = "abc123中国";
        byte[] bytes = str1.getBytes();//使用默认字符集转换
        System.out.println(Arrays.toString(bytes));

        byte[] gbks = str1.getBytes("gbk");
        System.out.println(Arrays.toString(gbks));

        System.out.println("*********************");

        String str2 = new String(bytes);//默认字符集解码
        System.out.println(str2);

//        String str3 = new String(gbks);//出现乱码（编码集与解码集不一致）
//        System.out.println(str3);

        String str4 = new String(gbks, "gbk");
        System.out.println(str4);
    }
}