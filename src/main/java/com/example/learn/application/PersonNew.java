package com.example.learn.application;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 本类用来演示:
 *
 * @Author: 陈冲
 * @Date: 2020/12/20 18:20
 */
@Data
//@PropertySource(value = {"classpath:custom.properties"},encoding = "utf-8")
@Configuration
@ConfigurationProperties(prefix = "personnew")
public class PersonNew {
    private String name;
    private Integer age ;
    private Integer number;
    private String uuid;
    private Integer max;
    private String value;
    private String greeting;

}
