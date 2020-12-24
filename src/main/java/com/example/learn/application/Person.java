package com.example.learn.application;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author: 陈冲
 * @Date: 2020/12/20 18:09
 * @Description: 自定义配置文件
 */

@Data
//@PropertySource(value = {"classpath:custom.properties"},encoding = "utf-8")
@Configuration
public class Person {
    @Value("${person.name}")
    private String name;
    @Value("${person.age}")
    private int age;


}
