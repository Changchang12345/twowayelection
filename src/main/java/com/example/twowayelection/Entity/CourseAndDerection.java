package com.example.twowayelection.Entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class CourseAndDerection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseID;
    private String courseName;
    private float weight;
    private  float gradeLimit;
    @OneToMany(mappedBy = "course")
    private List<Judge> judges;
}
