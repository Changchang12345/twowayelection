package com.example.twowayelection.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class Judge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private  Double grade;
    private String detail;
    @ManyToOne
    private CourseAndDerection course;
    @ManyToOne
    private Student student;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP",
            insertable = false,updatable = false)
    private LocalDateTime updateTime;
}
