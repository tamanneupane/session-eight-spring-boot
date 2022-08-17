package com.squareflakes.training.service;

import com.squareflakes.training.model.MyService;
import com.squareflakes.training.repository.ProtfolioServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public MyService updateService(Long serviceId, MyService myService) {
        Optional<MyService> storedService = protfolioServiceRepository.findById(serviceId);
        if(storedService.isPresent()){
            System.out.println("Yes the service is present");

            MyService serviceToBeUpdated = storedService.get();
            System.out.println(serviceToBeUpdated);

            serviceToBeUpdated.setTitle(myService.getTitle());
            serviceToBeUpdated.setIcon(myService.getIcon());
            serviceToBeUpdated.setDescription(myService.getDescription());

            return protfolioServiceRepository.save(serviceToBeUpdated);

        }else{
            System.out.println("No the service is not present");
            throw new RuntimeException("The service you are trying to update is not found.");
        }
    }

    public void deleteService(Long serviceId) {
        Optional<MyService> storedService = protfolioServiceRepository.findById(serviceId);
        if(storedService.isPresent()){
            protfolioServiceRepository.deleteById(serviceId);
        }else{
            throw new RuntimeException("The service you are trying to delete is not found.");
        }
    }
}
