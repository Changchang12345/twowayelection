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
import java.util.List;

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
    public CourseAndDerection getCourse(int id){
        return courseRepository.findById(id).orElse(null);
    }
    public Judge getJudge(int id){
        return judgeRepository.findById(id).orElse(null);
    }
    public Teacher getTeacher(int id){
        return teacherRepository.findById(id).orElse(null);
    }
    public void setAverageGrade(Integer stuID){
        Integer i = 1;
        Integer j = 0;
        Integer flag = 0;
        Double ans=0.0;
        while (true){
            if(getJudge(i).getStudent().getStuID()==stuID){
                if(getJudge(i).getGrade()>=getJudge(i).getCourse().getGradeLimit()){
                    flag = 1;
                }
                else {flag = 0;}
            }
            i++;
            if(getJudge(i)==null&&flag==1){
              List<Judge> judges = judgeRepository.list1(stuID);
              for(j=0;j<judges.size();j++){
                  Double g = judges.get(j).getGrade();
                  g = g*getCourse(i).getWeight();
                  ans =ans+g;
              }
            }
            if(getJudge(i)==null)break;
        }
        getStudent(stuID).setAverageGrade(ans);
    }
}
