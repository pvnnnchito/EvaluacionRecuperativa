package com.example.recuperativa.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.recuperativa.models.Paciente;
import com.example.recuperativa.repositories.PacienteRepository;

@Service
public class PacienteService {

    @Autowired
    PacienteRepository pacienteRepository;

    //guardaremos un paciente
    public void guardarPaciente(@Valid Paciente paciente) {
        pacienteRepository.save(paciente);
    }
    //obtendremos una lista de pacientes
    public List<Paciente> findAll() {
        return pacienteRepository.findAll();
    }

}
