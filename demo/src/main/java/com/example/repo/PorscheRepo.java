package com.example.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.Porsche;

public interface PorscheRepo extends CrudRepository<Porsche, Long>{
    
}
