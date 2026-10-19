package com.example.Backend.DTOS;

public record EmpresaDTO(
        String id,
        String nombre,
        String nit,
        String sector,
        Boolean activa
) {}