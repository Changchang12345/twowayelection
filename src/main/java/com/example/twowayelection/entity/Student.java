package com.example.twowayelection.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stuID;
    private String stuName;
    private float grade;
    @OneToMany(mappedBy = "student" )//及时加载,fetch = FetchType.EAGER
    private List<Judge> judges;
    @Column(columnDefinition = "timestamp default current_timestamp",
            insertable = false,updatable = false)
    private LocalDateTime insertTime;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP",
            insertable = false,
            updatable = false)
    private LocalDateTime updateTime;
}
