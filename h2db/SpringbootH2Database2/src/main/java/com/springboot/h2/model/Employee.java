package com.springboot.h2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue
    private int id;
    private String lastName;
    private String firstName;
    private String address;
    private String city;
    private double salary;
    private double age;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startJobDate;
    private int benefit;

    private String email;

}
