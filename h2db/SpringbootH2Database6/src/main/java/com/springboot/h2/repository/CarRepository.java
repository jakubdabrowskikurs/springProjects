package com.springboot.h2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.h2.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

}
