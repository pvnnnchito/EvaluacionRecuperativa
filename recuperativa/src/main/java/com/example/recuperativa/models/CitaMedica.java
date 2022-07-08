package com.example.recuperativa.models;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="citas_medicas")
public class CitaMedica {
    

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private Integer paciente_id;
    private Date hora;
    private String area_medica;
    
    
    public CitaMedica() {
    }


    public CitaMedica(Integer paciente_id, Date hora, String area_medica) {
        this.paciente_id = paciente_id;
        this.hora = hora;
        this.area_medica = area_medica;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public Integer getPaciente_id() {
        return paciente_id;
    }


    public void setPaciente_id(Integer paciente_id) {
        this.paciente_id = paciente_id;
    }


    public Date getHora() {
        return hora;
    }


    public void setHora(Date hora) {
        this.hora = hora;
    }


    public String getArea_medica() {
        return area_medica;
    }


    public void setArea_medica(String area_medica) {
        this.area_medica = area_medica;
    }

    
}
