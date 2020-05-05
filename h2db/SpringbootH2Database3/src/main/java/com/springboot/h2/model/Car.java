package com.springboot.h2.model;

import lombok.*;

import javax.persistence.*;
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
    public Employee employees;

    private String name;

    private String model;

    @ToString.Exclude
    private Date registrationDate;

}
