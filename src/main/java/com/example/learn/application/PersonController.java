package com.example.learn.application;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: 陈冲
 * @Date: 2020/12/21 14:23
 */
//等于@Response加上一个@Controller
@RestController
public class PersonController {
    @Resource
    private Person person;
    @RequestMapping("/person")
    public String person(){
        return "姓名:"+person.getName()+"\t"+"年龄"+person.getAge();
    }

}
