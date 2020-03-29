package com.example.twowayelection.repository;

import com.example.twowayelection.entity.CourseAndDerection;
import com.example.twowayelection.entity.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends BaseRepository<CourseAndDerection,Integer> {
    @Query("from CourseAndDerection a where a.teacher.teacherID=:teacherID")
    Page<CourseAndDerection> list(@Param("teacherID") Integer teacherID, Pageable pageable);
}
