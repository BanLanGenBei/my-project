package com.example.learn.POI;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

/**
 * 本类功能:
 *
 * @author chenchong
 * @date 2020/12/1 19:36
 */
public class ReadExcelData {
    public static void main(String[] args) {

        try {
            System.out.println(readExcelData("D:\\Excel\\student.xlsx", "学生信息表"));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static Set readExcelData(String fileName,String sheetName) throws IOException {
        InputStream in = new FileInputStream(fileName);
        XSSFWorkbook wb = new XSSFWorkbook(in);
        XSSFSheet sheet = wb.getSheet(sheetName);
        //获取表格一共有多少行
        int rows = sheet.getPhysicalNumberOfRows();
        //定义一个set集合
        Set studentSet = new HashSet();
        for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
            studentSet.add(sheet.getRow(i));
        }
        return studentSet;
    }

    //获取excel中的城市的Id
    public static Set getAllCityId(String fileName,String sheetName) throws IOException {
        InputStream inputStream = new FileInputStream(fileName);
        XSSFWorkbook wb = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = wb.getSheet(sheetName);
        //获取表格一共有多少行
        int rows = sheet.getPhysicalNumberOfRows();
        //定义一个set集合
        Set citySet = new HashSet<String>();
        System.out.println(rows);
        for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {

            if(sheet.getRow(i).getCell(0)!=null) {
                //.getRowValue是返回的显示的值
                citySet.add(sheet.getRow(i).getCell(0).getRawValue());
            }
        }
        return citySet;

    }
}
