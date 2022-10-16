package com.usa.p1.service;

import com.usa.p1.model.Car;
import com.usa.p1.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public Car create(Car car) {
        if (car.getIdCar() == null){
            return carRepository.save(car);
        }else{
            Optional<Car> carNew = getCar(car.getIdCar());
            if (carNew.isEmpty()){
                return carRepository.save(car);
            }else {
                return car;
            }
        }
    }


    public Optional<Car> getCar(Integer id) {
        return carRepository.findById(id);
    }


    public List<Car> cars() {
        return (List<Car>) carRepository.findAll();
    }

    public Car update(Car car) {
        if (car != null && car.getIdCar() != null){
            if (carRepository.existsById(car.getIdCar())){
                Optional<Car> oldCar = carRepository.findById(car.getIdCar());
                Car editedCar = oldCar.get();
                if (car.getName() != null){
                    editedCar.setName(car.getName());
                }
                if (car.getBrand() != null){
                    editedCar.setBrand(car.getBrand());
                }
                if (car.getYear() != 0){
                    editedCar.setYear(car.getYear());
                }
                if (car.getDescription() != null){
                    editedCar.setDescription(car.getDescription());
                }
                if (car.getGama() != null){
                    editedCar.setGama(car.getGama());
                }
                if (car.getMessages() != null){
                    editedCar.setMessages(car.getMessages());
                }
                if (car.getReservations() != null){
                    editedCar.setReservations(car.getReservations());
                }
                return carRepository.save(editedCar);
            }else{
                return car;
            }
        }else {
            return car;
        }
    }

    public boolean delete(Integer id) {
        if(carRepository.existsById(id)){
            carRepository.deleteById(id);
            return true;
        }else
            return false;
    }
}
