package com.example.recuperativa.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.recuperativa.models.CitaMedica;
import com.example.recuperativa.repositories.CitaRepository;

@Service
public class CitaService {
    @Autowired
    CitaRepository citaRepository;

    public void guardarCitas(@Valid CitaMedica citaMedica) {
        citaRepository.save(citaMedica);
    }

    public List<CitaMedica> findAll() {
        return citaRepository.findAll();
    }
    
}
