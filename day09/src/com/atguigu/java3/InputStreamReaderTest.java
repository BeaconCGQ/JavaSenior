package com.atguigu.java3;

import org.junit.Test;

import java.io.*;

/**
 * 处理流之二：转换流
 * <p>
 * 1.转换流：属于字符流
 * InputStreamReader：将一个字节的输入流转换为字符的输入流
 * OutputStreamWriter将一个字符的输出流转换为字节的输出流
 * 2.作用：提供字节流与字符流之间转换
 * <p>
 * 3.字节、字节数组 ---> 字符数组、字符串  ：解码
 * <p>
 * 4.字符集
 *  ASCII：美国标准信息交换码。 用一个字节的7位可以表示。
 *  ISO8859-1：拉丁码表。欧洲码表 用一个字节的8位表示。
 *  GB2312：中国的中文编码表。最多两个字节编码所有字符
 *  GBK：中国的中文编码表升级，融合了更多的中文文字符号。最多两个字节编码
 *  Unicode：国际标准码，融合了目前人类使用的所有字符。为每个字符分配唯一的字符码。所有的文字都用两个字节来表示。
 *  UTF-8：变长的编码方式，可用1-4个字节来表示一个字符。
 *
 * @description:
 * @author: 86173
 * @date: 2021/4/21 20:55
 */
public class InputStreamReaderTest {
    /**
     * 此时处理异常仍然应该使用try结构
     * 字节输入流到字符输入流转换
     */
    @Test
    public void test1() throws IOException {

        FileInputStream fis = new FileInputStream("dbcp.txt");
        InputStreamReader isr = new InputStreamReader(fis);
        //参数2具体使用字符集取决于文件保存时使用的字符集
//        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");//使用IDEA系统默认字符集

        char[] cbuf = new char[20];
        int len;
        while ((len = isr.read(cbuf)) != -1) {
            String str = new String(cbuf, 0, len);
            System.out.println(str);
        }
        isr.close();
    }

    /**
     * 综合使用InputStreamRead、OutputStreamWriter
     * @throws IOException
     */
    @Test
    public void test2() throws IOException {
        //1.造文件、造流
        File file1 = new File("dbcp.txt");
        File file2 = new File("dbcpGBK.txt");

        FileInputStream fis = new FileInputStream(file1);
        FileOutputStream fos = new FileOutputStream(file2);

        InputStreamReader isr = new InputStreamReader(fis,"utf-8");
        OutputStreamWriter osw = new OutputStreamWriter(fos,"gbk");
        //2.读写过程
        char[] cbuf = new char[20];
        int len;
        while((len = isr.read(cbuf)) != -1){
            osw.write(cbuf,0,len);
        }
        //3.资源关闭
        isr.close();
        osw.close();

    }


}
