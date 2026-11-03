package com.example.Backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Backend.model.Prioridades;

public interface IPrioridades extends JpaRepository<Prioridades, String> {
    
}