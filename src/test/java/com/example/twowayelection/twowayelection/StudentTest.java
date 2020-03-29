package com.example.twowayelection.twowayelection;

import com.example.twowayelection.entity.CourseAndDerection;
import com.example.twowayelection.entity.Judge;
import com.example.twowayelection.entity.Student;
import com.example.twowayelection.entity.Teacher;
import com.example.twowayelection.repository.CourseRepository;
import com.example.twowayelection.repository.JudgeRepository;
import com.example.twowayelection.repository.StudentRepository;
import com.example.twowayelection.service.ProjectService;
import com.jayway.jsonpath.internal.function.numeric.Average;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;
import javax.transaction.Transactional;


@Slf4j
@SpringBootTest

public class StudentTest {
@Autowired
 private ProjectService projectService;
@Autowired
private StudentRepository studentRepository;
@Autowired
private JudgeRepository judgeRepository;
@Autowired
private CourseRepository courseRepository;
@Transactional
@Rollback(value = false)
@Test
    public void init(){
    Student s1 = new Student();
    s1.setStuName("花花");
    s1.setStuNumber(2017224398);
    projectService.addStudent(s1);

    Teacher t1 = new Teacher();
    t1.setTeacherName("BO");
    t1.setPassword("12345");
    t1.setTotalNumber(10);
    projectService.addTeacher(t1);

    CourseAndDerection c1 = new CourseAndDerection();
    c1.setCourseName("Java程序设计（1、2班）");
    c1.setGradeLimit(80.00);
    c1.setWeight(1.5);
    c1.setTeacher(t1);
    projectService.addCourse(c1);

    CourseAndDerection c2 = new CourseAndDerection();
    c2.setCourseName("Web开发技术（1、2班）");
    c2.setGradeLimit(83.00);
    c2.setWeight(1.0);
    c2.setTeacher(t1);
    projectService.addCourse(c2);

    CourseAndDerection c3 = new CourseAndDerection();
    c3.setCourseName("Web框架开发");
    c3.setGradeLimit(78.00);
    c3.setWeight(2.0);
    c3.setTeacher(t1);
    projectService.addCourse(c3);

    CourseAndDerection c4 = new CourseAndDerection();
    c4.setCourseName("Docker学习小组");
    c4.setGradeLimit(78.00);
    c4.setWeight(2.5);
    c4.setTeacher(t1);
    projectService.addCourse(c4);

    Judge j1 = new Judge();
    j1.setCourse(c1);
    j1.setDetail("花花的Java程序设计课");
    j1.setStudent(s1);
    j1.setGrade(82.00);
    projectService.addJudge(j1);

    Judge j2 = new Judge();
    j2.setCourse(c2);
    j2.setDetail("花花的web开发技术课");
    j2.setStudent(s1);
    j2.setGrade(87.00);
    projectService.addJudge(j2);
}
    @Test
    public void testAverage(){
    while(true){
        Integer i = 1;
            projectService.setAverageGrade(i);
            i++;
            if(projectService.getStudent(i)==null)break;
    }
    }
    @Test
    public void testFetch(){
    log.debug(projectService.getStudent(1).getStuName());
    }
    @Test
    public void testFetch2(){
    projectService.getStudent(1).getJudges()
            .forEach(a->log.debug(a.getDetail()));
    }

    @Test
    public void testStuNameLists(){
        studentRepository.list("花花")
                .forEach(s1->log.debug("{}",s1.getStuName()));
    }
    @Test
    public void testStuList(){
    judgeRepository.list(1).forEach(u->log.debug(u.getStuName()));
    }
    @Test
    public  void testStudent(){
    log.debug("{}",judgeRepository.find(1).getStuName());
    }
    @Test
    public void testCourse(){
    judgeRepository.list1(1)
            .forEach(u->log.debug("{}",u.getCourse().getCourseName()));
    }
    @Test
    public  void testCourse1(){
        courseRepository.list(1, PageRequest.of(0, 20))
                .getContent()
                .forEach(u->log.debug("{}",u.getCourseName()));
    }
    @Transactional
    @Rollback(value = false)
    @Test
    public void testStu(){
    studentRepository.deleteStu(2);
    }
}
