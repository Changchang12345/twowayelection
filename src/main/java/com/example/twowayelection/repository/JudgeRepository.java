package com.example.twowayelection.repository;

import com.example.twowayelection.entity.CourseAndDerection;
import com.example.twowayelection.entity.Judge;
import com.example.twowayelection.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JudgeRepository extends BaseRepository<Judge,Integer> {
    @Query("select a.student from Judge a where a.course.courseID=:id")
    List<Student> list(@Param("id") Integer id);

    @Query("select a.student from Judge a where a.student.stuID=:uid")
    Student find(@Param("uid") Integer uid);

    @Query("from Judge a where a.student.stuID=:uid")
    List<Judge> list1(@Param("uid")Integer uid);
}
