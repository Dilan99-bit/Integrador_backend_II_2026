package com.example.Backend.service;

import com.example.Backend.model.Evidencias;
import com.example.Backend.repository.IEvidencias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SEvidencias {

    @Autowired
    private IEvidencias iEvidencias;

    public List<Evidencias> listarTodas() {
        return iEvidencias.findAll();
    }

    public Evidencias guardar(Evidencias evidencias) {
        return iEvidencias.save(evidencias);
    }

    public Optional<Evidencias> buscarPorId(Long id) {
        return iEvidencias.findById(id);
    }

    public void eliminar(Long id) {
        iEvidencias.deleteById(id);
    }
}