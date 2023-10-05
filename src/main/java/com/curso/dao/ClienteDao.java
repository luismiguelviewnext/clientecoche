package com.curso.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.model.Cliente;

public interface ClienteDao extends JpaRepository<Cliente, Integer> {
    
}
