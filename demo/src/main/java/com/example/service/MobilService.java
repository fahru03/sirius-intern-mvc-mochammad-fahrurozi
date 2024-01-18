package com.example.service;


import java.util.Optional;

import com.example.entity.Mobil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repo.MobilRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MobilService {

    @Autowired
    private MobilRepo repo;   

    public Iterable<Mobil> findAll(){
        return repo.findAll();
    }

    public void addMobil(Mobil mobil){
       repo.save(mobil);
    }

    public void deleteById(long id){
        repo.deleteById(id);
    }

    public Optional<Mobil> findById(long id){
        return repo.findById(id);
    }

    public void updateMobil(Mobil mobil){
        repo.save(mobil);
    }
}

