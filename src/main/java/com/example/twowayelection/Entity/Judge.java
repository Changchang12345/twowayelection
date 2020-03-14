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
    @ManyToOne
    private CourseAndDerection course;
    @ManyToOne
    private Student student;
    private int qualifiedNumber;
    private String detail;
}
