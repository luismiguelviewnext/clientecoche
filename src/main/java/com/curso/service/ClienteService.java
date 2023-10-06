package com.curso.service;

import java.util.List;
import com.curso.model.Cliente;
import com.curso.model.Coche;

/**
 * Interfaz para el servicio que maneja las operaciones CRUD para los objetos Cliente y Coche.
 * @author Luis Miguel Albarracín Castillo
 */
public interface ClienteService {

    /**
     * Guarda un nuevo cliente.
     *
     * @param cliente El cliente a guardar.
     */
    void nuevoCliente(Cliente cliente);

    /**
     * Lista todos los clientes.
     *
     * @return Una lista de clientes.
     */
    List<Cliente> listarclientes();

    /**
     * Obtiene un cliente por su identificador único.
     *
     * @param id El identificador del cliente.
     * @return El cliente con el identificador dado.
     */
    Cliente obtenerPorId(int idCliente);

    /**
     * Actualiza un cliente.
     *
     * @param cliente El cliente con los datos actualizados.
     */
    void actualizar(Cliente cliente);

    /**
     * Elimina un cliente por su identificador único.
     *
     * @param id El identificador del cliente.
     */
    void eliminar(int idCliente);

    // ----------------------------------------- Métodos para los coches -------------------------------------------

    /**
     * Guarda un nuevo coche.
     *
     * @param coche El coche a guardar.
     */
    void nuevoCoche(Coche coche);

    /**
     * Lista todos los coches.
     *
     * @return Una lista de coches.
     */
    List<Coche> listarcoches();

    /**
     * Obtiene un coche por su identificador único.
     *
     * @param id El identificador del coche.
     * @return El coche con el identificador dado.
     */
    Coche obtenerCochePorId(int id);

    /**
     * Actualiza un coche.
     *
     * @param coche El coche con los datos actualizados.
     */
    void actualizarCoche(Coche coche);

    /**
     * Elimina un coche por su identificador único.
     *
     * @param id El identificador del coche.
     */
    void eliminarCoche(int id);
}
