package com.example.Backend.Mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.Backend.DTOS.EmpresaDTO;
import com.example.Backend.model.Empresa;

@Component
public class IEmpresaMapper {

    public EmpresaDTO toDTO(Empresa empresa) {
        if (empresa == null) return null;
        return new EmpresaDTO(
                empresa.getId(),
                empresa.getNombre(),
                empresa.getNit(),
                empresa.getSector(),
                empresa.getActiva()
        );
    }

    public List<EmpresaDTO> toDTOList(List<Empresa> empresas) {
        return empresas.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
