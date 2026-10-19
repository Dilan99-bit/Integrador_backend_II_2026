package com.example.Backend.Mapper;

import java.util.List;

import com.example.Backend.DTOS.RegistrosDTO;
import com.example.Backend.model.Registros;

public interface IRegistrosMapper {

    RegistrosDTO toDTO(Registros registro);

    List<RegistrosDTO> toDTOList(List<Registros> registros);
}
