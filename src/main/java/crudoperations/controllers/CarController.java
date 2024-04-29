package crudoperations.controllers;

import crudoperations.entities.Car;
import crudoperations.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarRepository carRepository;


    @PostMapping
    public Car createCar(@RequestBody Car car) {
        Car savedCar = carRepository.save(car);
        return savedCar;
    }


    @GetMapping
    public List<Car> Cars() {
        List<Car> cars = (List<Car>) carRepository.findAll();
        return cars;
    }


    @GetMapping("/{id}")
    public Optional<Car> getCar(@PathVariable long id) {
        Optional<Car> car = carRepository.findById(id);
        return car;
    }


    @PutMapping("/{id}")
    public Car updateCarType(@PathVariable Long id, @RequestParam Car car) {
        car.setType(car.getType());
        Car newCar = carRepository.save(car);
        return newCar;
    }


    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable long id) {
        carRepository.deleteById(id);
    }


    @DeleteMapping("/deleteAll")
    public void deleteAllCars(@RequestParam List<Long> ids) {
        carRepository.deleteAllById(ids);
    }
}