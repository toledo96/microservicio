package com.tutorial.bikeservice.service;

import com.tutorial.bikeservice.entity.Bike;
import com.tutorial.bikeservice.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BikeService {
    @Autowired
    private BikeRepository bikeRepository;

    public List<Bike> getAll(){
        return bikeRepository.findAll();
    }

    public Bike getUserById(int id){
        return bikeRepository.findById(id).orElse(null);
    }

    public Bike save(Bike user){
        Bike userNew = bikeRepository.save(user);
        return userNew;
    }

    public List<Bike> getCarByUserId(int userid){
        return bikeRepository.findByUserId(userid);
    }

}
