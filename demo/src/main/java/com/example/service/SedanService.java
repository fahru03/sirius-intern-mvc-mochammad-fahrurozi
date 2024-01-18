package com.example.service;


import java.util.Optional;

import com.example.entity.Sedan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repo.SedanRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SedanService {

    @Autowired
    private SedanRepo repo;   

    public Iterable<Sedan> findAll(){
        return repo.findAll();
    }

    public void addSedan(Sedan sedan){
       repo.save(sedan);
    }

    public void deleteById(long id){
        repo.deleteById(id);
    }

    public Optional<Sedan> findById(long id){
        return repo.findById(id);
    }

    public void updateSedan(Sedan sedan){
        repo.save(sedan);
    }
}

