package com.curso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Representa a un cliente en el sistema.
 * @author Luis Miguel Albarracín Castillo
 */
@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    private int idCliente;
    private String nombre;
    private int telefono;
    private String email;

    /**
     * Constructor por defecto.
     */
    public Cliente() {
        super();

    }

    /**
     * Constructor con el id del cliente.
     *
     * @param idCliente el identificador del cliente.
     */
    public Cliente(int idCliente) {
        super();
        this.idCliente = idCliente;
    }

    /**
     * Constructor completo.
     *
     * @param idCliente el identificador del cliente.
     * @param nombre    el nombre del cliente.
     * @param telefono  el teléfono del cliente.
     * @param email     el correo electrónico del cliente.
     */
    public Cliente(int idCliente, String nombre, int telefono, String email) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    /**
     * Constructor sin id.
     *
     * @param nombre   el nombre del cliente.
     * @param telefono el teléfono del cliente.
     * @param email    el correo electrónico del cliente.
     */
    public Cliente(String nombre, int telefono, String email) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    // Getters y setters
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + idCliente;
        return result;
    }

    /*
     * Método equals y hashcode para determinar si dos objetos son iguales.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cliente other = (Cliente) obj;
        if (idCliente != other.idCliente)
            return false;
        return true;
    }

    /*
     * Metodo toString para mostrar los datos del objeto.
     */
    @Override
    public String toString() {
        return "Cliente [idCliente=" + idCliente + ", nombre=" + nombre + ", telefono=" + telefono + ", email=" + email
                + "]";
    }

}
