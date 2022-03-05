package com.tutorial.userserivice.service;

import com.tutorial.userserivice.entity.User;
import com.tutorial.userserivice.feignclients.BikeFeignClient;
import com.tutorial.userserivice.feignclients.CarFeignClient;
import com.tutorial.userserivice.models.Bike;
import com.tutorial.userserivice.models.Car;
import com.tutorial.userserivice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CarFeignClient carFeignClient;

    @Autowired
    private BikeFeignClient bikeFeignClient;

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User getUserById(int id){
        return userRepository.findById(id).orElse(null);
    }

    public User save(User user){
        User userNew = userRepository.save(user);
        return userNew;
    }

    //Esto está en la interfaz CarFeign
    public Car saveCar(int userId, Car car){
        car.setUserId(userId);
        Car carNew = carFeignClient.save(car);
        return carNew;
    }
    
    public Bike saveBike(int userId,Bike bike){
        bike.setUserId(userId);
        Bike newBike = bikeFeignClient.save(bike);
        return newBike;
    }
}
