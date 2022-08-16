package com.squareflakes.training.controller;

import com.squareflakes.training.model.MyService;
import com.squareflakes.training.service.APIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class APIController {

//    @GetMapping(value = "/api/test/{someInfo}/{anotherInfo}")
//    public String test(@PathVariable(name = "someInfo") String someInfo, @PathVariable(name = "anotherInfo") String anotherInfo){
//        System.out.println(someInfo);
//        System.out.println(anotherInfo);
//        String[] splitted = anotherInfo.split("-");
//        String id = splitted[splitted.length - 1];
//        System.out.println(id);
//        return  "Your get API is working";
//    }
//
//    @PostMapping(value = "/api/test")
//    public String testPost(){
//        return  "Your post API is working";
//    }
//
//    @PutMapping(value = "/api/test")
//    public String testPut(){
//        return  "Your put API is working";
//    }
//
//    @DeleteMapping(value = "/api/test")
//    public String testDelete(){
//        return  "Your delete API is working";
//    }

    @Autowired
    private APIService apiService;

    @GetMapping(value = "/api/service")
    public Iterable<MyService> getServices(){
        return apiService.getAllService();
    }

    @PostMapping(value = "/api/service")
    public MyService createService(@RequestBody MyService myService){
       return apiService.createService(myService);
    }

}
