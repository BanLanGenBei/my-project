package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.example.model.entity.Student;
import com.example.mapper.StudentMapper;
import com.example.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2020-12-23
 */
@Service

public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {
    @Resource
    private StudentMapper studentMapper;
    /**
     * 添加一个学生
     * @param student
     * @return
     */
    @Override
    public int saveOneStudent(Student student) {
        int count = studentMapper.insert(student);
        return count;
    }

    /**
     * 根据id删除一个学生
     * @param id
     * @return
     */
    @Override
    public int deleteOneStudent(Integer id) {
        int count = studentMapper.delete(new LambdaQueryWrapper<Student>().eq(Student::getStuId, id));
        return count;
    }

    /**
     * 更新一个学生
     * @param student
     * @return
     */
    @Override
    public int updateStudent(Student student) {
        int count = studentMapper.update(student, new LambdaQueryWrapper<Student>().eq(Student::getStuId, student.getStuId()));
        return count;

    }

    /**
     * 根据id查询学生
     * @param id
     * @return
     */
    @Override
    public Student enquiryStudent(Integer id) {
        Student student = studentMapper.selectOne(new LambdaQueryWrapper<Student>().eq(Student::getStuId, id));
        return student;
    }



}
