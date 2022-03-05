package com.tutorial.carservice.service;

import com.tutorial.carservice.entity.Car;
import com.tutorial.carservice.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carroRepository;

    public List<Car> getAll(){
        return carroRepository.findAll();
    }

    public Car getUserById(int id){
        return carroRepository.findById(id).orElse(null);
    }

    public Car save(Car user){
        Car userNew = carroRepository.save(user);
        return userNew;
    }

    public List<Car> getCarByUserId(int userid){
        return carroRepository.findByUserId(userid);
    }

}
