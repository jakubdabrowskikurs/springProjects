package com.springboot.h2.controller;

import com.springboot.h2.model.Employee;
import com.springboot.h2.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequiredArgsConstructor
public class EmployeeController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final EmployeeService employeeService;

    private Set<Employee> employeeList = new HashSet<>();

    @GetMapping("/")
    public String index() {
        return "employee/index";
    }

    @RequestMapping(value = "/employee_form", method = RequestMethod.GET)
    public String showform(Model model) {
        log.info("Start");
        model.addAttribute("employee", new Employee());
        return "employee/employee_form";
    }

    @PostMapping(value = "/save")
    public ModelAndView save(@ModelAttribute(value = "emp") Employee employee) {
        if (employee.getId() == 0) {
            employeeService.save(employee);
            getEmployeeList().add(employee);
        } else {
            Employee empTemp = getEmployeeById(employee.getId());
            empTemp.setFirstName(employee.getFirstName());
            empTemp.setSalary(employee.getSalary());
            empTemp.setAddress(employee.getAddress());
            empTemp.setBenefit(employee.getBenefit());
            empTemp.setAge(employee.getAge());
            empTemp.setCity(employee.getCity());
            empTemp.setLastName(employee.getLastName());
            empTemp.setStartJobDate(employee.getStartJobDate());
            empTemp.setEmail(employee.getEmail());
        }
        employeeService.save(employee);
        return new ModelAndView("redirect:/employee_list");
    }

    @PostMapping(value = "/delete")
    public ModelAndView delete(@RequestParam(value = "emp_id") String emp_id) {
        Employee employee = getEmployeeById(Integer.parseInt(emp_id));
        employeeService.delete(employee);
        employeeList.remove(employee);
        return new ModelAndView("redirect:/employee_list");
    }

    @PostMapping(value = "/edit")
    public ModelAndView edit(@RequestParam(value = "emp_id") String emp_id) {
        Employee employee = getEmployeeById(Integer.parseInt(emp_id));
        return new ModelAndView("employee/employee_form", "employee", employee);
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public ModelAndView test() {
        System.out.println("Test");
        return new ModelAndView("redirect:/employee_list");
    }

    @RequestMapping("/employee_list")
    public ModelAndView employee_list() {
        return new ModelAndView("employee/employee_list", "list", getEmployeeList());
    }

    private Employee getEmployeeById(int id) {
        return employeeList.stream().filter(f -> f.getId() == id).findFirst().get();
    }

    public Set<Employee> getEmployeeList() {
        return employeeList == null ? employeeList = employeeService.getAll() : employeeList;
    }
}