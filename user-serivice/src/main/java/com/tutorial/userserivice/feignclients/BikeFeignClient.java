package com.tutorial.userserivice.feignclients;

import com.tutorial.userserivice.models.Bike;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(name = "bike-service",url = "http://localhost:8003/bike")
//@FeignClient(name = "bike-service")
public interface BikeFeignClient {
    @PostMapping()
    public Bike save(@RequestBody Bike car);

    @GetMapping("/byuser/{userId}")
    List<Bike> getBikes(@PathVariable("userId") int userId);

}
