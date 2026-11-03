package com.example.Backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "prioridades")
public class Prioridades {

    @Id
    @Column(length = 15, nullable = false)
    private String idprioridad;

    @Column(length = 50, nullable = false)
    private String nombre;

    @Column(length = 100, nullable = false)
    private String descripcion;

    public Prioridades() {
    }

    public Prioridades(String idprioridad, String nombre, String descripcion) {
        this.idprioridad = idprioridad;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getIdprioridad() {
        return idprioridad;
    }

    public void setIdprioridad(String idprioridad) {
        this.idprioridad = idprioridad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
