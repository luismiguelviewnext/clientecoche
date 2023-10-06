package com.curso.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso.model.Cliente;

/**
 * Repositorio para operaciones CRUD de la entidad {@link Cliente}.
 * Utiliza Spring Data JPA para facilitar la interacción con la base de datos.
 */
public interface ClienteDao extends JpaRepository<Cliente, Integer> {
    
}
