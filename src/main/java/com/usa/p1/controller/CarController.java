package com.usa.p1.controller;

import com.usa.p1.model.Car;
import com.usa.p1.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Car")
@CrossOrigin(origins = "*")
public class CarController {
    @Autowired
    private CarService carService;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void createBox(@RequestBody Car car){
        carService.create(car);
    }

    @GetMapping("/all")
    public List<Car> getBoxes(){
        return carService.cars();
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Car updateBox(@RequestBody Car car){
        return carService.update(car);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBox(@PathVariable ("id") Integer id){
        carService.delete(id);
    }
}
