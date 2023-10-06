package com.curso.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.model.Cliente;

/**
 * Repositorio para operaciones CRUD de la entidad {@link Cliente}.
 * Utiliza Spring Data JPA para facilitar la interacción con la base de datos.
 * @author Luis Miguel Albarracín Castillo
 */
public interface ClienteDao extends JpaRepository<Cliente, Integer> {
    
}
