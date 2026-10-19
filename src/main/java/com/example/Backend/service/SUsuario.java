package com.example.Backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Backend.model.Usuario;
import com.example.Backend.repository.IUsuario;

@Service
public class SUsuario {

    private final IUsuario usuarioRepository;

    public SUsuario(IUsuario usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional(readOnly = true)
    public List<Usuario> listarUsuarios() throws Exception {
        try {
            return usuarioRepository.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage(), error);
        }
    }

    @Transactional
    public Usuario adicionarUsuario(Usuario usuario) throws Exception {
        try {
            if (usuario == null) {
                throw new Exception("El usuario no puede ser nulo.");
            }
            return usuarioRepository.save(usuario);
        } catch (Exception error) {
            throw new Exception(error.getMessage(), error);
        }
    }

    @Transactional(readOnly = true)
    public Usuario consultarUsuarioId(String id) throws Exception {
        try {
            Optional<Usuario> usuario = usuarioRepository.findById(id);
            if (usuario.isPresent()) {
                return usuario.get();
            }
            throw new Exception("No se encontró el usuario con id " + id + ".");
        } catch (Exception error) {
            throw new Exception(error.getMessage(), error);
        }
    }

    @Transactional
    public void eliminarUsuario(String id) throws Exception {
        try {
            usuarioRepository.deleteById(id);
        } catch (Exception error) {
            throw new Exception(error.getMessage(), error);
        }
    }
}
