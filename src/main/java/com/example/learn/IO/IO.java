package com.example.learn.IO;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;

import java.io.*;
import java.util.Properties;

/**
 * 本类功能:
 *
 * @author chenchong
 * @date 2020/11/30 15:09
 */
public class IO {
    public static void main(String[] args) {
//        copyIoUtil("D://Excel/student.xlsx","D://Excel/studentCopyUtil.xlsx");

//        InputStream in = new FileInputStream("src/main/resources/weatherKey.txt");
        InputStream in = null;
        try {
            Properties properties = new Properties();
            in = new FileInputStream("src/main/java/com/example/learn/IO/student.properties");
            properties.load(in);
            System.out.println(properties.getProperty("age"));
        } catch (FileNotFoundException e) {
            System.out.println("找不到文件的位置!");
        } catch (IOException e) {
            e.printStackTrace();
        }
//        String read = IoUtil.read(in, "UTF-8");
//        System.out.println(read);


    }

    //原生的写法
    private static void copy(String src,String target){
        //1.确定流的对象
        InputStream in = null;
        OutputStream out = null;
        //2.确定文件输入流 - 确定源头
        File file;
        try {
            in =  new FileInputStream(src);
            out = new FileOutputStream(target);
            //3.单个字节单个字节的进行读取
            //定义一个变量 - 用来保存每次读取到的内容
            int len = -1;
            //循环读取
            while (true){
                //如果已经到达了尾部 in.read()返回-1
                len = in.read();
                //退出循环的条件
                if(len==-1){
                    break;
                }
                out.write(len);
            }
            System.out.println("文件拷贝成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null!=in){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null!=out){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //IoUtil工具类
    public static void copyIoUtil(String src,String target){
        BufferedInputStream inputStream = FileUtil.getInputStream(src);
        BufferedOutputStream outputStream = FileUtil.getOutputStream(target);
        IoUtil.copy(inputStream,outputStream);
        IoUtil.close(inputStream);
        IoUtil.close(outputStream);
    }



}
