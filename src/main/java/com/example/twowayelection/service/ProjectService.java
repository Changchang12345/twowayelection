package com.example.twowayelection.service;

import com.example.twowayelection.entity.CourseAndDerection;
import com.example.twowayelection.entity.Judge;
import com.example.twowayelection.entity.Student;
import com.example.twowayelection.entity.Teacher;
import com.example.twowayelection.repository.CourseRepository;
import com.example.twowayelection.repository.JudgeRepository;
import com.example.twowayelection.repository.StudentRepository;
import com.example.twowayelection.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProjectService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    TeacherRepository teacherRepository;
    @Autowired
    JudgeRepository judgeRepository;
    @Autowired
    CourseRepository courseRepository;
    public void addStudent(Student student){
        studentRepository.save(student);
    }
    public void addTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }
    public void addJudge(Judge judge){
        judgeRepository.save(judge);
    }
    public void addCourse(CourseAndDerection course){
        courseRepository.save(course);
    }
    public Student getStudent(int id){
        return studentRepository.findById(id).orElse(null);
    }
    public Teacher getTeacher(int id){
        return teacherRepository.findById(id).orElse(null);
    }
}
