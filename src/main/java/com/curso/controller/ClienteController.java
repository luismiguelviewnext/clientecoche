/**
 * La clase ClienteController es un controlador REST que maneja operaciones CRUD para las entidades 
 * Cliente y Coche.
 * @author Luis Miguel Albarracín Castillo
 */
package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.MediaType; 
import org.springframework.web.bind.annotation.DeleteMapping; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.PutMapping; 
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Cliente; 
import com.curso.model.Coche; 
import com.curso.service.ClienteService;

@RestController 
public class ClienteController {

    @Autowired     
    ClienteService ejemplarService;

    /**
     * Método para listar todos los clientes.
     *
     * @return Lista de clientes.
     */
    @GetMapping(value = "cliente", produces = MediaType.APPLICATION_JSON_VALUE)     
    public List listarClientes() {
        return ejemplarService.listarclientes();
    }

    /**
     * Método para obtener un cliente por su ID.
     *
     * @param id El ID del cliente.
     * @return El cliente con el ID proporcionado.
     */
    @GetMapping(value = "cliente/{id}", produces = MediaType.APPLICATION_JSON_VALUE)     
    public Cliente obtenerPorId(@PathVariable("id") int idCliente) {
        return ejemplarService.obtenerPorId(idCliente);     
    }

    /**
     * Método para agregar un nuevo cliente.
     *
     * @param cliente El cliente a agregar.
     */
    @PostMapping(value = "cliente", produces = MediaType.APPLICATION_JSON_VALUE)     
    public void nuevoEjemplar(@RequestBody Cliente cliente) {
        ejemplarService.nuevoCliente(cliente);
    }

    /**
     * Método para actualizar un cliente existente.
     *
     * @param cliente El cliente con la información actualizada.
     */
    @PutMapping(value = "cliente", consumes = MediaType.APPLICATION_JSON_VALUE)     
    public void actualizar(@RequestBody Cliente cliente) {
        ejemplarService.actualizar(cliente);     
    }

    /**
     * Método para eliminar un cliente por su ID.
     *
     * @param id El ID del cliente a eliminar.
     */
    @DeleteMapping(value = "cliente/{id}", produces = MediaType.APPLICATION_JSON_VALUE)     
    public void eliminar(@PathVariable("id") int idCliente) {
        ejemplarService.eliminar(idCliente);     
    }

    //---- Métodos para coches

    /**
     * Método para agregar un nuevo coche.
     *
     * @param coche El coche a agregar.
     */
    @PostMapping(value = "coche", produces = MediaType.APPLICATION_JSON_VALUE)     
    public void nuevoCoche(@RequestBody Coche coche){
        ejemplarService.nuevoCoche(coche);             
    }

    /**
     * Método para listar todos los coches.
     *
     * @return Lista de coches.
     */
    @GetMapping(value = "coche", produces = MediaType.APPLICATION_JSON_VALUE)     
    public List listarcoches(){
        return ejemplarService.listarcoches();     
    }

    /**
     * Método para obtener un coche por su ID.
     *
     * @param id El ID del coche.
     * @return El coche con el ID proporcionado.
     */
    @GetMapping(value = "coche/{id}", produces = MediaType.APPLICATION_JSON_VALUE)     
    public Coche obtenerCochePorId(@PathVariable("id") int id){
        return ejemplarService.obtenerCochePorId(id);     
    }

    /**
     * Método para actualizar un coche existente.
     *
     * @param coche El coche con la información actualizada.
     */
    @PutMapping(value="coche", consumes = MediaType.APPLICATION_JSON_VALUE)     
    public void actualizarCoche(@RequestBody Coche coche){
        ejemplarService.actualizarCoche(coche);     
    }

    /**
     * Método para eliminar un coche por su ID.
     *
     * @param id El ID del coche a eliminar.
     */
    @DeleteMapping(value="coche/{id}", produces = MediaType.APPLICATION_JSON_VALUE)     
    public void eliminarCoche(@PathVariable("id") int id){
        ejemplarService.eliminarCoche(id);     
    } 
}
