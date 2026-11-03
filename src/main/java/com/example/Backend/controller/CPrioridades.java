package com.example.Backend.controller;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Backend.model.Prioridades;
import com.example.Backend.service.SPrioridades;


@RestController
@RequestMapping("/api/prioridades")
@CrossOrigin(origins = "http://localhost:3000")
public class CPrioridades {

    private final SPrioridades sPrioridades;

    public CPrioridades(SPrioridades sPrioridades) {
        this.sPrioridades = sPrioridades;
    }

    @GetMapping
    public ResponseEntity<?> listarPrioridades() {
        try {
            List<Prioridades> prioridades = sPrioridades.listarPrioridades();
            return ResponseEntity.ok(prioridades);
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(error.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> consultarPrioridadId(@PathVariable String id) {
        try {
            return ResponseEntity.ok(sPrioridades.consultarPrioridadId(id));
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(error.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> adicionarPrioridad(@RequestBody Prioridades prioridad) {
        try {
            Prioridades prioridadGuardada = sPrioridades.adicionarPrioridad(prioridad);
            return ResponseEntity.status(HttpStatus.CREATED).body(prioridadGuardada);
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPrioridad(@PathVariable String id) {   
        try {
            sPrioridades.eliminarPrioridad(id);
            return ResponseEntity.noContent().build();
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(error.getMessage());
        }
    }
    
}