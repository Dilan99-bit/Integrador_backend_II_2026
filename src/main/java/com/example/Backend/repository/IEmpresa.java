package com.example.Backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Backend.model.Empresa;

@Repository
public interface IEmpresa extends JpaRepository<Empresa, String> {
}