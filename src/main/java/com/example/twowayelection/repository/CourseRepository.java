package com.example.twowayelection.repository;

import com.example.twowayelection.entity.CourseAndDerection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<CourseAndDerection,Integer> {
}
