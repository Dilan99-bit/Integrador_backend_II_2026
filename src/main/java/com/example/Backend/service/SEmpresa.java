package com.example.Backend.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Backend.DTOS.EmpresaDTO;
import com.example.Backend.Mapper.IEmpresaMapper;
import com.example.Backend.model.Empresa;
import com.example.Backend.repository.IEmpresa;

@Service
public class SEmpresa {

    private final IEmpresa iEmpresaRepository;
    private final IEmpresaMapper empresaMapper;

    public SEmpresa(IEmpresa iEmpresaRepository, IEmpresaMapper empresaMapper) {
        this.iEmpresaRepository = iEmpresaRepository;
        this.empresaMapper = empresaMapper;
    }

    @Transactional(readOnly = true)
    public List<EmpresaDTO> listarEmpresas() throws Exception {
        try {
            return empresaMapper.toDTOList(iEmpresaRepository.findAll());
        } catch (Exception error) {
            throw new Exception(error.getMessage(), error);
        }
    }

    @Transactional
    public Empresa guardarEmpresa(Empresa empresa) throws Exception {
        try {
            if (empresa == null) {
                throw new Exception("La empresa no puede ser nula.");
            }

            if (empresa.getNombre() == null || empresa.getNombre().isBlank()) {
                throw new Exception("El nombre de la empresa es obligatorio.");
            }

            if (empresa.getId() == null || empresa.getId().isBlank()) {
                empresa.setId(UUID.randomUUID().toString());
            }

            return iEmpresaRepository.save(empresa);
        } catch (Exception error) {
            throw new Exception(error.getMessage(), error);
        }
    }

    @Transactional(readOnly = true)
    public Optional<Empresa> buscarPorId(String id) throws Exception {
        try {
            return iEmpresaRepository.findById(id);
        } catch (Exception error) {
            throw new Exception(error.getMessage(), error);
        }
    }

    @Transactional
    public void eliminarEmpresa(String id) throws Exception {
        try {
            if (id == null || id.isBlank()) {
                throw new Exception("El id de la empresa es obligatorio.");
            }

            iEmpresaRepository.deleteById(id);
        } catch (Exception error) {
            throw new Exception(error.getMessage(), error);
        }
    }
}