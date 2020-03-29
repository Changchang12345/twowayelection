package com.example.twowayelection.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer teacherID;
    private String teacherName;
    private String password;
    private Integer qualifiedNumber;
    private Integer totalNumber;
    @OneToMany(mappedBy = "teacher")
    private List<CourseAndDerection> courses;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP",
            insertable = false,updatable = false)
    private LocalDateTime updateTime;

}
