package com.example.twowayelection.Entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teacherID;
    private String teacherName;
    private String password;
    private int totalNumber;
    @OneToMany
    private List<CourseAndDerection> courses;
}
