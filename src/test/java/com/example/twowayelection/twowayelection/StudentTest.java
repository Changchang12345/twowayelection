package com.example.twowayelection.twowayelection;

import com.example.twowayelection.entity.Student;
import com.example.twowayelection.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Slf4j
@SpringBootTest
@Transactional
@Rollback(value = false)
public class StudentTest {
@Autowired
    private StudentRepository studentRepository;

@Test
    public void test_addStudent(){
    Student student = new Student();
    student.setStuName("hua");
    student.setGrade(90);
    studentRepository.save(student);
}
}
