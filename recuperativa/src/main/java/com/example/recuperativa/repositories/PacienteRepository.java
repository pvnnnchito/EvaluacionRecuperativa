package com.example.recuperativa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.recuperativa.models.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository <Paciente, Long>{
    
}
