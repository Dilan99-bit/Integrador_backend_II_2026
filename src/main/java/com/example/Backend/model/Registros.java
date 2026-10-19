package com.example.Backend.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "registros")
public class Registros {

    @Id
    @Column(length = 15, nullable = false)
    private String idregistro;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idusuario", nullable = false)
    private Usuario usuario;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idreto", nullable = false)
    private Retos reto;

    @Column(nullable = false)
    private LocalDate fechaRegistro;

    @Column(length = 10, nullable = false)
    private String estado;

    @Column(length = 100, nullable = false)
    private String observaciones;

    public Registros() {
    }

    public Registros(String idregistro,
         Usuario usuario, Retos reto,
         LocalDate fechaRegistro,
         String estado, String observaciones) {
            
        this.idregistro = idregistro;
        this.usuario = usuario;
        this.reto = reto;
        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
        this.observaciones = observaciones;
    }

    public String getIdregistro() {
        return idregistro;
    }

    public void setIdregistro(String idregistro) {
        this.idregistro = idregistro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Retos getReto() {
        return reto;
    }

    public void setReto(Retos reto) {
        this.reto = reto;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
