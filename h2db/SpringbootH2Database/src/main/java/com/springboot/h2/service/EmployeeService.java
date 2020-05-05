package com.springboot.h2.service;

import com.springboot.h2.model.Employee;
import com.springboot.h2.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository repository;

    public void save(final Employee employee) {
        repository.save(employee);
    }

    public void delete(final Employee employee) {
        repository.delete(employee);
    }

    public Set<Employee> getAll() {
        return repository.findAll().stream().collect(Collectors.toSet());
    }

}
