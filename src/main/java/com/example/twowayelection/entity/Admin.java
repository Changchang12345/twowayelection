package com.example.twowayelection.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@Entity
public class Admin {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer adminID;
    private Integer adminNumber;
    private String adminName;
    private String Password;
    @Column(columnDefinition = "timestamp default current_timestamp",
            insertable = false,updatable = false)
    private LocalDateTime insertTime;
}
