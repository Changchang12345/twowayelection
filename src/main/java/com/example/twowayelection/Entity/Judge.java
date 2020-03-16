package com.example.twowayelection.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Judge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int qualifiedNumber;
    private String detail;
    @ManyToOne
    private CourseAndDerection course;
    @ManyToOne
    private Student student;
}
