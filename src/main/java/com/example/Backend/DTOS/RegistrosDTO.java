package com.example.Backend.DTOS;

import java.time.LocalDate;

public record RegistrosDTO(
        String idregistro,
        String idusuario,
        String idreto,
        LocalDate fechaRegistro,
        String estado,
        String observaciones
) {}
