package com.example.twowayelection.repository;

import com.example.twowayelection.base.impl.BaseRepository;
import com.example.twowayelection.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends BaseRepository<Student,Integer> {

}
