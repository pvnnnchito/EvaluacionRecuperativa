package com.example.recuperativa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.recuperativa.models.CitaMedica;

@Repository
public interface CitaRepository extends JpaRepository <CitaMedica, Long>{
    
}
