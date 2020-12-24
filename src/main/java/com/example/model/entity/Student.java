package com.example.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author ${author}
 * @since 2020-12-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Student extends Model<Student> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "stu_id", type = IdType.AUTO)
    private Integer stuId;

    /**
     * 学生的姓名
     */
    private String stuName;

    /**
     * 学生的年龄
     */
    private Integer stuAge;

    public Student(String stuName, Integer stuAge) {
        this.stuName = stuName;
        this.stuAge = stuAge;
    }

    @Override
    protected Serializable pkVal() {
        return this.stuId;
    }

}
