package com.example.Backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "evidencias")
public class Evidencias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEvidencia;

    private String descripcion;
    private String urlArchivo; // Para guardar la ruta o enlace de la evidencia

    public Evidencias() {}

    public Evidencias(String descripcion, String urlArchivo) {
        this.descripcion = descripcion;
        this.urlArchivo = urlArchivo;
    }

    // Getters y Setters
    public Long getIdEvidencia() {
        return idEvidencia;
    }

    public void setIdEvidencia(Long idEvidencia) {
        this.idEvidencia = idEvidencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlArchivo() {
        return urlArchivo;
    }

    public void setUrlArchivo(String urlArchivo) {
        this.urlArchivo = urlArchivo;
    }
}
