package com.example.service;

import com.example.model.entity.Student;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ${author}
 * @since 2020-12-23
 */
public interface IStudentService extends IService<Student> {

    /**
     * 添加一个学生
     * @param student
     * @return
     */
    int saveOneStudent(Student student);

    /**
     * 删除一个学生,根据id进行删除
     * @param
     * @return
     */
    int deleteOneStudent(Integer id);

    /**
     * 修改学生
     * @param student
     * @return
     */
    int updateStudent(Student student);

    /**
     * 根据id查询学生
     * @param id
     * @return
     */
    Student enquiryStudent(Integer id);

}
