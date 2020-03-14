package com.example.twowayelection.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stuID;
    private String stuName;
    private int courseID;
    private float grade;
    @OneToMany(mappedBy = "student")
    private List<Judge> judges;

}
