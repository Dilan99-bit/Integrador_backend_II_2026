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

import com.example.Backend.model.Registros;
import com.example.Backend.service.SRegistros;

@RestController
@RequestMapping("/api/registros")
@CrossOrigin(origins = "http://localhost:3000")
public class CRegistros {

    private final SRegistros sRegistros;

    public CRegistros(SRegistros sRegistros) {
        this.sRegistros = sRegistros;
    }

    @GetMapping
    public ResponseEntity<?> listarRegistros() {
        try {
            List<Registros> registros = sRegistros.listarRegistros();
            return ResponseEntity.ok(registros);
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(error.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> consultarRegistroId(@PathVariable String id) {
        try {
            return ResponseEntity.ok(sRegistros.consultarRegistroId(id));
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(error.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> adicionarRegistro(@RequestBody Registros registro) {
        try {
            Registros registroGuardado = sRegistros.adicionarRegistro(registro);
            return ResponseEntity.status(HttpStatus.CREATED).body(registroGuardado);
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarRegistro(@PathVariable String id) {
        try {
            sRegistros.eliminarRegistro(id);
            return ResponseEntity.noContent().build();
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(error.getMessage());
        }
    }
}
