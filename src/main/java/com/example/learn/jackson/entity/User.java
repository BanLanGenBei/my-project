package com.example.learn.jackson.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

/**
 * 本类功能:
 *
 * @author chenchong
 * @date 2020/12/2 20:58
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
//JsonIgnoreProperties是类级别的,反序列化和序列化都会忽视这些属性
//@JsonIgnoreProperties(value = {"age","birthday"})
public class User {
    private String name;

    private Integer age;

    /**
     *     这个注解表示，如果值为null，则不返回，还可以在类上添加这个注释，当实体类与json互相转换的时候，
     *     属性值为null的不参与序列化。
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDate birthday;

    //属性级别的,放在属性上,反序列化和序列化都会忽视这些属性
//    @JsonIgnore
    private String email;



}
