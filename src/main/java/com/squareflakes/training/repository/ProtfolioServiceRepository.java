package com.squareflakes.training.repository;

import com.squareflakes.training.model.MyService;
import org.springframework.data.repository.CrudRepository;

public interface ProtfolioServiceRepository extends CrudRepository<MyService,Long> {
}
