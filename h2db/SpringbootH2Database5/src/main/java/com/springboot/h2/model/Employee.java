package com.springboot.h2.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @EqualsAndHashCode.Exclude
    private String lastName;
    @EqualsAndHashCode.Exclude
    private String firstName;
    @EqualsAndHashCode.Exclude
    private String address;
    @EqualsAndHashCode.Exclude
    private String city;
    @EqualsAndHashCode.Exclude
    private double salary;
    @EqualsAndHashCode.Exclude
    private double age;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @EqualsAndHashCode.Exclude
    private LocalDate startJobDate;
    @EqualsAndHashCode.Exclude
    private int benefit;
    @EqualsAndHashCode.Exclude
    private String email;
    
    @OneToMany(mappedBy = "employee", cascade=CascadeType.ALL)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Car> cars;

}

