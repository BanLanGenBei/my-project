package com.example.learn.reflect.entity;

/**
 * 本类功能:
 *
 * @author chenchong
 * @date 2020/12/15 17:09
 */
public class Book {
    private Integer id;
    private String name;
    private String type;

    public String price;


    public Book() {
    }

    public Book(Integer id, String name, String tye) {
        this.id = id;
        this.name = name;
        this.type = tye;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void test(String name, String type){
        String str = name +""+ type;
        System.out.println(str);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Book{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
