package com.example.twowayelection.repository;

import com.example.twowayelection.entity.Judge;
import com.example.twowayelection.entity.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends BaseRepository<Student,Integer> {

    @Query("from Student s where s.stuName =:name")
    List<Student> list(@Param("name") String name);

    @Modifying
    @Query("delete from Student a where a.stuID=:sid")
    void deleteStu(@Param("sid") Integer sid);

}
