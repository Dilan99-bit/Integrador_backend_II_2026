package com.example.Backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Backend.model.Registros;
import com.example.Backend.repository.IRegistros;

@Service
public class SRegistros {

    private final IRegistros registrosRepository;

    public SRegistros(IRegistros registrosRepository) {
        this.registrosRepository = registrosRepository;
    }

    @Transactional(readOnly = true)
    public List<Registros> listarRegistros() throws Exception {
        try {
            return registrosRepository.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage(), error);
        }
    }

    @Transactional
    public Registros adicionarRegistro(Registros registro) throws Exception {
        try {
            if (registro == null) {
                throw new Exception("El registro no puede ser nulo.");
            }
            return registrosRepository.save(registro);
        } catch (Exception error) {
            throw new Exception(error.getMessage(), error);
        }
    }

    @Transactional(readOnly = true)
    public Registros consultarRegistroId(String id) throws Exception {
        try {
            Optional<Registros> registro = registrosRepository.findById(id);
            if (registro.isPresent()) {
                return registro.get();
            }
            throw new Exception("No se encontró el registro con id " + id + ".");
        } catch (Exception error) {
            throw new Exception(error.getMessage(), error);
        }
    }

    @Transactional
    public void eliminarRegistro(String id) throws Exception {
        try {
            registrosRepository.deleteById(id);
        } catch (Exception error) {
            throw new Exception(error.getMessage(), error);
        }
    }
}
