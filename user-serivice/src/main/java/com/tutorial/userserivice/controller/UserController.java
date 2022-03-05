package com.tutorial.userserivice.controller;

import com.tutorial.userserivice.entity.User;
import com.tutorial.userserivice.models.Bike;
import com.tutorial.userserivice.models.Car;
import com.tutorial.userserivice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAll(){
        List<User> users = userService.getAll();
        if(users.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable("id") int id){
        User user = userService.getUserById(id);
        if(user == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping()
    public ResponseEntity<User> save(@RequestBody User user){
        User userNew = userService.save(user);
        return ResponseEntity.ok(userNew);
    }

    @PostMapping("/savecar/{userId}")
    public ResponseEntity save(@PathVariable("userId") int userId,@RequestBody Car car ){
        if(userService.getUserById(userId) == null){
            return ResponseEntity.notFound().build();
        }
        Car carnew = userService.saveCar(userId,car);
        return ResponseEntity.ok(carnew);
    }

    @PostMapping("/savebike/{userId}")
    public ResponseEntity save(@PathVariable("userId") int userId,@RequestBody Bike bike ){
        if(userService.getUserById(userId) == null){
            return ResponseEntity.notFound().build();
        }
        Bike carnew = userService.saveBike(userId,bike);
        return ResponseEntity.ok(carnew);
    }

}
