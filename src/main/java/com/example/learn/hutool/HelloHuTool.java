package com.example.learn.hutool;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.*;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 本类功能:
 *
 * @author chenchong
 * @date 2020/12/10 20:24
 */
public class HelloHuTool {
    public static void main(String[] args) {
        System.out.println("========计时器=======");
        TimeInterval timer = DateUtil.timer();


        String format = DateUtil.format(new Date(), "yyyy-MM-dd");
        System.out.println(format);
        System.out.println("================");
        String s = DateUtil.formatDateTime(new Date());
        System.out.println(s);
        System.out.println("================");
        DateTime dateTime = DateUtil.offsetDay(new Date(), 3);
        System.out.println(dateTime);
        System.out.println("=======日期的时间差=========");
        String dateStr1 = "2017-03-01 22:33:23";
        Date date1 = DateUtil.parse(dateStr1);
        String dateStr2 = "2017-04-01 23:33:23";
        Date date2 = DateUtil.parse(dateStr2);
        System.out.println(DateUtil.between(date1, date2, DateUnit.DAY));
        System.out.println("========格式化时间差=====");
        System.out.println(DateUtil.formatBetween(date1, date2, BetweenFormatter.Level.HOUR));

        System.out.println("======日期时间的偏移============");
        System.out.println(DateUtil.offsetHour(new Date(), 1));

        System.out.println("=======执行花费的时间===========");
        System.out.println(timer.interval());
        System.out.println(timer.intervalRestart());


        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        String format1 = dateTimeFormatter.format(localDateTime);
        System.out.println(format1);

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        System.out.println(CollectionUtil.isEmpty(list));
        System.out.println("=============");
        System.out.println(CollectionUtil.contains(list, 2));


        String version = "127.3.4.2";
        String replace = StringUtils.replace(version, ".", "");
        System.out.println(replace);



    }
}
