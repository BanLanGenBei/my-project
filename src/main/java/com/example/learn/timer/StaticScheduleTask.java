package com.example.learn.timer;


import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 本类功能:
 *
 * @author chenchong
 * @date 2020/12/8 17:00
 */

/**
 * fixedDelay=5000
 * 以一个固定延迟时间5秒钟调用一次执行,这个周期是以上一个调用任务的完成时间为基准,在上一个任务完成之后,5秒再次执行
 *
 * fixedRate = 5000
 * 以一个固定速率5s来调用一次执行,这个周期是以上一个任务开始时间为基准,从上一任务开始执行后5s再次调用
 *
 *
 * cron = "0/5 * * * * *"
 *
 */


@Component
public class StaticScheduleTask {
//    @Scheduled(cron = "0/5 * * * * *")
    public void cron(){
        System.out.println("cron:"+ new Date());
    }

//    @Scheduled(fixedDelay = 10000)
    public void fixedDelay(){
        System.out.println("fixedDelay:"+ "我是fixedDelay");
    }


}
