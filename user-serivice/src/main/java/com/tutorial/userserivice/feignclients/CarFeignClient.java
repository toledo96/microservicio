package com.tutorial.userserivice.feignclients;

import com.tutorial.userserivice.models.Car;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "car-service",url = "http://localhost:8002/car")
public interface CarFeignClient {

    @PostMapping()
    public Car save(@RequestBody Car car);

}
