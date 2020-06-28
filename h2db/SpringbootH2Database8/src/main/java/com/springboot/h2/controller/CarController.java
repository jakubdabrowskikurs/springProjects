package com.springboot.h2.controller;

import com.springboot.h2.model.Car;
import com.springboot.h2.service.CarService;
import com.springboot.h2.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;
    private final EmployeeService employeeService;

    @RequestMapping(value = "/car_form", method = RequestMethod.GET)
    public String showForm(Model model) {
        model.addAttribute("car", new Car());
        model.addAttribute("empList", employeeService.getAll());
        return "car/car_form";
    }

    @PostMapping(value = "/save_car")
    public String save(@ModelAttribute @Valid Car car, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("car", car);
            model.addAttribute("empList", employeeService.getAll());
            return "car/car_form";
        }

        carService.save(car);
        return "redirect:/car_list";
    }

    @PostMapping(value = "/delete_car")
    public ModelAndView delete(@RequestParam(value = "car_id") int car_id) {
        Car car = carService.getById(car_id);
        carService.delete(car);
        return new ModelAndView("redirect:/car_list");
    }

    @PostMapping(value = "/edit_car")
    public String edit(@RequestParam(value = "car_id") int car_id, Model model) {
        Car car = carService.getById(car_id);
        model.addAttribute("employee", car.getEmployee());
        model.addAttribute("car", car);
        model.addAttribute("empList", employeeService.getAll());
        return "car/car_form";
    }

    @RequestMapping("/car_list")
    public ModelAndView carList() {
        return new ModelAndView("car/car_list", "list", carService.getAll());
    }
}