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

import com.example.Backend.DTOS.UsuarioDTO;
import com.example.Backend.Mapper.IUsuarioMapper;
import com.example.Backend.model.Usuario;
import com.example.Backend.service.SUsuario;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "http://localhost:3000")
public class CUsuario {

    private final SUsuario sUsuario;
    private final IUsuarioMapper usuarioMapper;

    public CUsuario(SUsuario sUsuario, IUsuarioMapper usuarioMapper) {
        this.sUsuario = sUsuario;
        this.usuarioMapper = usuarioMapper;
    }

    @GetMapping
    public ResponseEntity<?> listarUsuarios() {
        try {
            List<UsuarioDTO> usuarios = usuarioMapper.toDTOList(sUsuario.listarUsuarios());
            return ResponseEntity.ok(usuarios);
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(error.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> consultarUsuarioId(@PathVariable String id) {
        try {
            UsuarioDTO usuario = usuarioMapper.toDTO(sUsuario.consultarUsuarioId(id));
            return ResponseEntity.ok(usuario);
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(error.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> adicionarUsuario(@RequestBody Usuario usuario) {
        try {
            Usuario usuarioGuardado = sUsuario.adicionarUsuario(usuario);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(usuarioMapper.toDTO(usuarioGuardado));
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable String id) {
        try {
            sUsuario.eliminarUsuario(id);
            return ResponseEntity.noContent().build();
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(error.getMessage());
        }
    }
}
