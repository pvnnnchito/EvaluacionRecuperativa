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

import com.example.recuperativa.models.CitaMedica;
import com.example.recuperativa.services.CitaService;

@Controller
@RequestMapping("/citas")
public class CitaController {
    @Autowired
    CitaService citaService;
    
    @RequestMapping("")
    public String inicio(@ModelAttribute("citaMedica") CitaMedica citaMedica) {

        return "citas.jsp";
    }

    @PostMapping("/guardar")
    public String guardarCitas(@Valid @ModelAttribute("citaMedica") CitaMedica citaMedica,
            BindingResult resultado,
            Model model) {

        if (resultado.hasErrors()) {
            model.addAttribute("msgError", "Datos erroneos");
            return "citas.jsp";
        } else {
            // enviamos el objeto a persistir en base datos
            citaService.guardarCitas(citaMedica);
            // obtener un alista de autos
            List<CitaMedica> listaCitas = citaService.findAll();
            // pasamos la lista de autos al jsp
            model.addAttribute("citasCapturadas", listaCitas);
            return "mostrarPaciente.jsp";
        }
    }

    @RequestMapping("/mostrar")
    public String mostrar(Model model) {
        // obtener una lista de autos
        List<CitaMedica> listaCitas = citaService.findAll();
        // pasamos la lista de autos al jsp
        model.addAttribute("citasCapturadas", listaCitas);
        return "mostrarPaciente.jsp";

    }
}
