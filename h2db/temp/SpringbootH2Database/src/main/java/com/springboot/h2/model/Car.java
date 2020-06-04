package com.springboot.h2.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    public Employee employee;

    private String name;

    private String model;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ToString.Exclude
    private LocalDate registrationDate;

}
