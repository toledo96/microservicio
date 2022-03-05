package com.tutorial.userserivice.feignclients;

import com.tutorial.userserivice.models.Bike;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "bike-service",url = "http://localhost:8003/bike")
public interface BikeFeignClient {
    @PostMapping()
    public Bike save(@RequestBody Bike car);
}
