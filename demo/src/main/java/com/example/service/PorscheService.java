package com.example.service;


import java.util.Optional;

import com.example.entity.Porsche;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repo.PorscheRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PorscheService {

    @Autowired
    private PorscheRepo repo;   

    public Iterable<Porsche> findAll(){
        return repo.findAll();
    }

    public void addPorsche(Porsche porsche){
       repo.save(porsche);
    }

    public void deleteById(long id){
        repo.deleteById(id);
    }

    public Optional<Porsche> findById(long id){
        return repo.findById(id);
    }

    public void updatePorsche(Porsche porsche){
        repo.save(porsche);
    }
}

