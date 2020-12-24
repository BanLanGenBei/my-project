package com.example.learn.POI;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 本类功能:
 *
 * @author chenchong
 * @date 2020/12/1 18:51
 */
public class PoiTest {
    public static void main(String[] args){
        //创建工作蒲
        XSSFWorkbook wb = new XSSFWorkbook();
        //工作表
        XSSFSheet sheet = wb.createSheet("学生信息表");
        //标头行，代表第一行
        XSSFRow header = sheet.createRow(0);
        //创建单元格，0代表第一行第一列
        header.createCell(0).setCellValue("学号");
        header.createCell(1).setCellValue("姓名");
        header.createCell(2).setCellValue("专业");
        header.createCell(3).setCellValue("班级");
        header.createCell(4).setCellValue("身份证号");
        header.createCell(5).setCellValue("宿舍号");
        header.createCell(6).setCellValue("报道日期");

        XSSFRow row = sheet.createRow(1);
        row.createCell(0).setCellValue("001");
        row.createCell(1).setCellValue("陈冲");
        row.createCell(2).setCellValue("计算机科学与技术");
        row.createCell(3).setCellValue("2班");
        row.createCell(4).setCellValue("320882199806013817");
        row.createCell(5).setCellValue("123");
        row.createCell(6).setCellValue("20170901");

        XSSFRow row2 = sheet.createRow(2);
        row2.createCell(0).setCellValue("002");
        row2.createCell(1).setCellValue("王慧");
        row2.createCell(2).setCellValue("软件工程");
        row2.createCell(3).setCellValue("1班");
        row2.createCell(4).setCellValue("320882199806013817");
        row2.createCell(5).setCellValue("123");
        row2.createCell(6).setCellValue("20170901");
        //设置列的宽度
        // getPhysicalNumberOfCells()代表这行有多少包含数据的列
        for (int i = 0; i < header.getPhysicalNumberOfCells() ; i++) {
            // POI设置列宽度时比较特殊，它的基本单位是1/255个字符大小，
            // 因此我们要想让列能够盛的下20个字符的话，就需要用255*20
            sheet.setColumnWidth(i,255*20);
        }
        //设置行高，30像素
        header.setHeightInPoints(30);

        FileOutputStream fos = null;
        try {
            //输出文件要么是\\ 要么是/ 否则会报错
            fos = new FileOutputStream("E:\\Excel\\student.xlsx");
            //向指定的文件写入内容
            wb.write(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }


        //关闭流
        try {
            assert fos != null;
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("文件生成完毕");
    }




}
