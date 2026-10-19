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

import com.example.Backend.DTOS.EmpresaDTO;
import com.example.Backend.model.Empresa;
import com.example.Backend.service.SEmpresa;

@RestController
@RequestMapping("/api/empresas")
@CrossOrigin(origins = "http://localhost:3000")
public class CEmpresa {

    private final SEmpresa sEmpresa;

    public CEmpresa(SEmpresa sEmpresa) {
        this.sEmpresa = sEmpresa;
    }

    @GetMapping
    public ResponseEntity<?> listarEmpresas() {
        try {
            List<EmpresaDTO> empresas = sEmpresa.listarEmpresas();
            return ResponseEntity.ok(empresas);
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(error.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> buscarPorId(@PathVariable String id) {
        try {
            return sEmpresa.buscarPorId(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<?> guardarEmpresa(@RequestBody Empresa empresa) {
        try {
            Empresa empresaGuardada = sEmpresa.guardarEmpresa(empresa);
            return ResponseEntity.status(HttpStatus.CREATED).body(empresaGuardada);
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarEmpresa(@PathVariable String id) {
        try {
            sEmpresa.eliminarEmpresa(id);
            return ResponseEntity.noContent().build();
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(error.getMessage());
        }
    }
}