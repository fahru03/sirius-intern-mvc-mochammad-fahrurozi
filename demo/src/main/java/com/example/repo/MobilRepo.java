package com.example.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.Mobil;

public interface MobilRepo extends CrudRepository<Mobil, Long>{
    
}
