package com.example.Backend.repository;

import com.example.Backend.model.Evidencias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEvidencias extends JpaRepository<Evidencias, Long> {
    // Aquí puedes agregar consultas personalizadas si lo necesitas en el futuro
}