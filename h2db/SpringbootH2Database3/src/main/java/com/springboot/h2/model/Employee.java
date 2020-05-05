package com.springboot.h2.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

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

    @OneToMany
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Car> cars;

}
