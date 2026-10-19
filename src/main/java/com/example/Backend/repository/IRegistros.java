package com.example.Backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Backend.model.Registros;

public interface IRegistros extends JpaRepository<Registros, String> {
}
