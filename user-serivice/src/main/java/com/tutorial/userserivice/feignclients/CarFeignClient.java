package com.tutorial.userserivice.feignclients;

import com.tutorial.userserivice.models.Car;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "car-service",url = "http://localhost:8002/car")
//@FeignClient(name = "car-service")
//@RequestMapping("/car")
public interface CarFeignClient {

    @PostMapping()
    Car save(@RequestBody Car car);

    @GetMapping("/byuser/{userId}")
    List<Car> getCars(@PathVariable("userId") int userId);

}
