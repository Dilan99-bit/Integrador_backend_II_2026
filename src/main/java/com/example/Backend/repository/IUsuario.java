package com.example.Backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Backend.model.Usuario;

public interface IUsuario extends JpaRepository<Usuario, String> {
}
