package com.example.twowayelection.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class CourseAndDerection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseID;
    private String courseName;
    private Double weight;
    private  Double gradeLimit;
    @OneToMany(mappedBy = "course")
    private List<Judge> judges;
    @ManyToOne
    private Teacher teacher;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP",
            insertable = false,updatable = false)
    private LocalDateTime updateTime;
}
