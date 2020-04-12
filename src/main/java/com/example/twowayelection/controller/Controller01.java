package com.example.twowayelection.controller;


import com.example.twowayelection.entity.Admin;
import com.example.twowayelection.entity.Student;
import com.example.twowayelection.entity.Teacher;
import com.example.twowayelection.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@Validated
@RequestMapping("/api/twowayelection/")
public class Controller01 {
    @Autowired
    private ProjectService projectService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    //登录界面(教师/管理员)
        @PostMapping("/teacher/login")
        public Map postLogin(@RequestBody Teacher teacher){
            Teacher t = projectService.getTeacher(teacher.getTeacherNumber());
            //先查询用户是否存在
            if(t==null||!passwordEncoder.matches(teacher.getPassword(), t.getPassword())){
                log.debug("failed");
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"用户名密码错误");
            }
            else {
                log.debug("登陆成功");//后需添加token操作
            }
            return Map.of("Teacher",t);
    }
    @PostMapping("/students/login")
    public Map postLogin(@RequestBody Student student){
        Student s = projectService.getStudent(student.getStuNumber());
        //查询学号是否存在
        if(s==null){
            log.debug("failed");
        }
        else log.debug("进入查看选修课界面");
        return Map.of("Student",s);
    }
    //管理员登录
        public Map postLogin(@RequestBody Admin admin){
            Admin a = projectService.getAdmin(admin.getAdminNumber());
            //查询管理员是否存在
            if(a==null||!passwordEncoder.matches(admin.getPassword(), a.getPassword())){
                log.debug("failed");
            }
            else log.debug("进入后台管理页面");
            return Map.of("Admin",a);
        }
    //学生选课选方向和是否选中该导师界面（学生登录后跳转,无需密码）
        @GetMapping("students/{sid}/courses")
        public Map getCourses(@PathVariable int sid){return Map.of("key","选课界面");}
    //返回被选中学生界面(教师登录后跳转)
        @GetMapping("teacher/{tid}/qualifiedStudent")
        public Map getQualifiedStudent(@PathVariable int tid){
            return Map.of("合格学生名单", projectService.setQualifiedStudent(tid));
        }
    //被选中(退选)界面
        @GetMapping("students/{sid}/result")

        public Map getResult(@PathVariable int sid){
            Student s = projectService.setQualifiedStudent(projectService.getStudent(sid)
                    .getStuID()).stream()
                    .filter(a->a.getStuNumber()==sid)
                    .findFirst()
                    .orElse(null);
            if(s==null)
            return Map.of("key","退选");
            else return Map.of("key","被选中");
        }
    //管理员后台注入学生信息界面
        @PostMapping("admin/modifyStudents")
        public Map setStudent(@RequestBody Student student){
            log.debug("{}",student.getStuName());
            return Map.of();
        }
   //教师修改密码界面
        @PostMapping("teacher/{tid}/modifyPassword")
        public Map setPasswordT(@PathVariable int tid,String newPassword ){
            projectService.resetPassword(newPassword, tid);
            return Map.of("action", "success");
        }
   //管理员修改密码界面
        @PostMapping("admin/{aid}/modifyPassword")
        public Map setPasswordA(@PathVariable int aid,String newPassword){
            projectService.resetPassword1(newPassword, aid);
            return Map.of("action", "success");
        }
}
