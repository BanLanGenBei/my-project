package com.example.controller;


import com.example.common.reponse.BaseResult;
import com.example.model.entity.Student;
import com.example.service.IStudentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2020-12-23
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    @Resource
    private IStudentService studentService;

    /**
     * 添加一个学生
     * @param student
     * @return
     */
    @PostMapping("/saveOneStudent")
    public BaseResult saveOneStudent(@RequestBody Student student){
        int count = studentService.saveOneStudent(student);
        return BaseResult.success();
    }

    /**
     * 根据id删除一个学生
     * @param id
     * @return
     */
    @DeleteMapping("/deleteStudentById")
    public BaseResult deleteStudentById(Integer id){
        int count = studentService.deleteOneStudent(id);
        return BaseResult.success();

    }

    /**
     * 更新一个学生
     * @param student
     * @return
     */
    @PutMapping("/updateStudent")
    public BaseResult updateStudent(@RequestBody Student student){
        int count = studentService.updateStudent(student);
        return BaseResult.success();
    }

    /**
     * 根据id查询学生
     * @param id
     * @return
     */
    @GetMapping("/enquiryStudent")
    public BaseResult<Student> enquiryStudent(@RequestParam(value = "id",required = false,defaultValue = "30") Integer id){
        Student student = studentService.enquiryStudent(id);
        return BaseResult.success(student);

    }


    /**
     * 批量保存学生
     * @return
     */
    @GetMapping("/saveSomeStudent")
    public BaseResult<List<Student>> saveSomeStudent(){
        Student student = new Student("卢本伟",22);
        Student student1 = new Student("姿态",24);
        List<Student> studentList  = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student);
        studentService.saveBatch(studentList);
        return BaseResult.success(studentList);
    }





}

