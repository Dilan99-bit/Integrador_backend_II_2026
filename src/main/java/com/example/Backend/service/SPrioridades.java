package com.example.Backend.service;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.stereotype.Service;

import com.example.Backend.model.Prioridades;
import com.example.Backend.repository.IPrioridades;

import jakarta.transaction.Transactional;

@Service
public class SPrioridades {
    
    private final IPrioridades prioridadesRepository;

    public SPrioridades(IPrioridades prioridadesRepository) {
        this.prioridadesRepository = prioridadesRepository;
    }

    @Transactional(readOnly = true)
    public List<Prioridades> listarPrioridades() throws Exception {
        try {
            return prioridadesRepository.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage(), error);
        }
    }

    @Transactional
    public Prioridades adicionarPrioridad(Prioridades prioridad) throws Exception {
        try {
            if (prioridad == null) {
                throw new Exception("La prioridad no puede ser nula.");
            }
            return prioridadesRepository.save(prioridad);
        } catch (Exception error) {
            throw new Exception(error.getMessage(), error);
        }
    }

    @Transactional(readOnly = true)
    public Prioridades consultarPrioridadId(String id) throws Exception {
        try {
            Optional<Prioridades> prioridad = prioridadesRepository.findById(id);
            if (prioridad.isPresent()) {
                return prioridad.get();
            }
            throw new Exception("No se encontró la prioridad con id " + id + ".");
        } catch (Exception error) {
            throw new Exception(error.getMessage(), error);
        }
    }

    @Transactional
    public void eliminarPrioridad(String id) throws Exception {
        try {
            prioridadesRepository.deleteById(id);
        } catch (Exception error) {
            throw new Exception(error.getMessage(), error);
        }
    }
}