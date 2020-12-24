package com.example.learn.jwt;

import com.example.util.TokenUtil;

/**
 * @Author: 陈冲
 * @Date: 2020/12/20 17:14
 * @Description:
 */
public class HelloJWT {
    public static void main(String[] args) {
        System.out.println(TokenUtil.sign("chenchong", "1001"));
//        System.out.println(TokenUtil.verify("eyJUeXBlIjoiSnd0IiwidHlwIjoiSldUIiwiYWxnIjoiSFMyNTYifQ.eyJ1c2VySW5mbyI6ImNoZW5jaG9uZyIsIm90aGVyIjoi55S3IiwiZXhwIjoxNjA4NTQyMDQ2fQ.c3D4DeuwSpObwN0qEN_zd84ossQljYaufyGoeqk9NJo"));

        System.out.println(TokenUtil.getUserName(TokenUtil.sign("chenchong", "1001"), "other"));
    }


}
