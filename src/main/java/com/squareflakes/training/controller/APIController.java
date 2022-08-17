package com.squareflakes.training.controller;

import com.squareflakes.training.model.MyService;
import com.squareflakes.training.service.APIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class APIController {

    @Autowired
    private APIService apiService;

    @GetMapping(value = "/api/service")
    public Iterable<MyService> getServices() {
        return apiService.getAllService();
    }

    @PostMapping(value = "/api/service")
    public MyService createService(@RequestBody MyService myService) {
        return apiService.createService(myService);
    }

    @PutMapping(value = "/api/service/{id}")
    public MyService updateService(@PathVariable(name = "id") Long serviceId, @RequestBody MyService myService) {
        System.out.println(serviceId);
        System.out.println(myService);
        return apiService.updateService(serviceId, myService);
    }

    @DeleteMapping(value = "/api/service/{id}")
    public String deleteService(@PathVariable(name = "id") Long serviceId) {

        apiService.deleteService(serviceId);

        return "The service is deleted";
    }

}
