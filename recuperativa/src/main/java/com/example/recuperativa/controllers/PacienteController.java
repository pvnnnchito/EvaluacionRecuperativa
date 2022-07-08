package com.example.recuperativa.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.recuperativa.models.Paciente;
import com.example.recuperativa.services.PacienteService;

@Controller
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    @RequestMapping("")
    public String inicio(@ModelAttribute("paciente") Paciente paciente) {
        return "paciente.jsp";
    }

    @PostMapping("/guardar")
    public String guardarPaciente(@Valid @ModelAttribute("paciente") Paciente paciente,
            BindingResult resultado,
            Model model) {

        if (resultado.hasErrors()) {
            model.addAttribute("msgError", "Datos Erroneos");
            return "paciente.jsp";
        } else {
            pacienteService.guardarPaciente(paciente);

            List<Paciente> listaPacientes = pacienteService.findAll();

            model.addAttribute("pacientesCapturados", listaPacientes);
            return "mostrarPaciente.jsp";
        }
    }

    @RequestMapping("/mostrar")
    public String mostrar(Model model) {
        // obtener una lista de pacientes
        List<Paciente> listaPacientes = pacienteService.findAll();
        // pasamos la lista de pacientes al jsp
        model.addAttribute("pacientesCapturados", listaPacientes);
        return "mostrarPaciente.jsp";

    }

    
















}
