package com.example.recuperativa.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="pacientes")
public class Paciente {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private Integer rut;
    private String nombre;
    private Date fechaNacimiento;
    @Column(updatable = false)
    private Date createdAt;

    private Date updatedAt;

    @OneToOne(mappedBy = "paciente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private CitaMedica citaMedica;

    public Paciente() {
    }

    public Paciente(Integer rut, String nombre, Date fechaNacimiDate) {
        this.rut = rut;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getRut() {
        return rut;
    }

    public void setRut(Integer rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }


}
