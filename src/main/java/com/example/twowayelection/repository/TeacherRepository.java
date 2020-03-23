package com.example.twowayelection.repository;

import com.example.twowayelection.base.impl.BaseRepository;
import com.example.twowayelection.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends BaseRepository<Teacher,Integer> {
}
