package com.squareflakes.training.service;

import com.squareflakes.training.model.MyService;
import com.squareflakes.training.repository.ProtfolioServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class APIService {

    @Autowired
    private ProtfolioServiceRepository protfolioServiceRepository;

    public Iterable<MyService> getAllService(){
        return protfolioServiceRepository.findAll();
    }

    public MyService createService(MyService myService){
        return protfolioServiceRepository.save(myService);
    }
}
