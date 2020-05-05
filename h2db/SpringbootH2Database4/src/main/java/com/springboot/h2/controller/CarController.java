package com.springboot.h2.controller;

import com.springboot.h2.model.Car;
import com.springboot.h2.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    private Set<Car> carList = new HashSet<>();

    @RequestMapping(value = "/car_form", method = RequestMethod.GET)
    public String showform(Model model) {
        model.addAttribute("car", new Car());
        return "car/car_form";
    }

    @PostMapping(value = "/save_car")
    public ModelAndView save(@ModelAttribute(value = "car") Car car) {
        if (car.getId() == 0) {
            carService.save(car);
            getCarList().add(car);
        } else {
            Car carTemp = getCarById(car.getId());
            carTemp.setEmployee(car.getEmployee());
            carTemp.setModel(car.getModel());
            carTemp.setName(car.getName());
            carTemp.setRegistrationDate(car.getRegistrationDate());
        }
        carService.save(car);
        return new ModelAndView("redirect:/car_list");
    }

    @PostMapping(value = "/delete_car")
    public ModelAndView delete(@RequestParam(value = "car_id") String car_id) {
        Car car = getCarById(Integer.parseInt(car_id));
        carService.delete(car);
        carList.remove(car);
        return new ModelAndView("redirect:/car_list");
    }

    @PostMapping(value = "/edit_car")
    public ModelAndView edit(@RequestParam(value = "car_id") String car_id) {
        Car car = getCarById(Integer.parseInt(car_id));
        return new ModelAndView("car/car_form", "car", car);
    }

    @RequestMapping("/car_list")
    public ModelAndView carList() {
        return new ModelAndView("car/car_list", "list", getCarList());
    }

    private Car getCarById(int id) {
        return carList.stream().filter(f -> f.getId() == id).findFirst().get();
    }

    public Set<Car> getCarList() {
        return carList == null ? carList = carService.getAll() : carList;
    }
}