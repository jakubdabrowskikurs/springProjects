package com.springboot.h2.service;

import com.springboot.h2.model.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeService employeeService;

    @Mock
    private Employee employee;

    @Spy
    private Employee employeeSpy;

    @Test
    public void saveEmployeeTest() {
        employeeService.save(employee);
        Mockito.verify(employeeService).save(employee);

        System.out.println(employee);
        System.out.println(employeeSpy);

        Mockito.when(employeeService.getAll()).thenReturn(Stream.of(employee).collect(Collectors.toSet()));
        assertEquals(employeeService.getAll(), Stream.of(employee).collect(Collectors.toSet()));

        employeeService.delete(employee);
        Mockito.verify(employeeService).delete(employee);
    }
}
