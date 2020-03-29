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
    @OneToMany(mappedBy = "student")// ,fetch = FetchType.EAGER)//及时加载
    private List<Judge> judges;
    @Column(columnDefinition = "timestamp default current_timestamp",
            insertable = false,updatable = false)
    private LocalDateTime insertTime;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP",
            insertable = false,
            updatable = false)
    private LocalDateTime updateTime;
    private Integer stuNumber;
    private Double averageGrade;
}
