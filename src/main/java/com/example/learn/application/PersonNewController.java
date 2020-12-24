package com.example.learn.application;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 本类用来演示:
 *
 * @Author: 陈冲
 * @Date: 2020/12/20 18:43
 */
@RestController
@EnableConfigurationProperties({PersonNew.class})
public class PersonNewController {
    @Resource
    private PersonNew personNew;

    @RequestMapping(value = "/personnew")
    public String personNew(){
        return personNew.getName()+"\n"+personNew.getAge()+"\n"+personNew.getNumber()+"\n"+personNew.getUuid()+"\n"+personNew.getMax()
                +"\n"+personNew.getValue()+"\n"+personNew.getGreeting();
    }
}
