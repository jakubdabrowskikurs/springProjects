package com.springboot.h2.controller;

import com.springboot.h2.model.Car;
import com.springboot.h2.model.Employee;
import com.springboot.h2.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class EmployeeController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final EmployeeService employeeService;

    @GetMapping("/")
    public String index() {
        return "employee/index";
    }

    @RequestMapping(value = "/employee_form", method = RequestMethod.GET)
    public String showForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee/employee_form";
    }

    @PostMapping(value = "/save")
    public ModelAndView save(@ModelAttribute(value = "emp") Employee employee) {
        employeeService.save(employee);
        return new ModelAndView("redirect:/employee_list");
    }

    @PostMapping(value = "/delete")
    public ModelAndView delete(@RequestParam(value = "emp_id") int emp_id) {
        Employee employee = employeeService.getById(emp_id);
        employeeService.delete(employee);
        return new ModelAndView("redirect:/employee_list");
    }

    @PostMapping(value = "/edit")
    public ModelAndView edit(@RequestParam(value = "emp_id") int emp_id) {
        Employee employee = employeeService.getById(emp_id);
        return new ModelAndView("employee/employee_form", "employee", employee);
    }

    @PostMapping(value = "/addCar")
    public String addCar(Model model, @RequestParam(value = "emp_id") int emp_id) {
        Employee employee = employeeService.getById(emp_id);
        Car car = new Car();
        car.setEmployee(employee);
        model.addAttribute("car", car);
        model.addAttribute("empList", employeeService.getAll());
        return "car/car_form";
    }

    @RequestMapping("/employee_list")
    public ModelAndView employee_list() {
        return new ModelAndView("employee/employee_list", "list", employeeService.getAll());
    }
}