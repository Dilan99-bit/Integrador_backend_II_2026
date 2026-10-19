package com.example.Backend.DTOS;

public record UsuarioDTO(
        String idusuario,
        String nombre,
        String correo,
        String rol
) {}
