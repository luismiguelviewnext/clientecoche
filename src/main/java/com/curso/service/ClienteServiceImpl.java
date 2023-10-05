package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.curso.model.Cliente;
import com.curso.model.Coche;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public void nuevoCliente(Cliente cliente) {
        Coche[] coches = restTemplate.getForObject("http://localhost:8080/coche", Coche[].class);
        boolean cocheExistente = false;

        for (Coche coche : coches) {
            if (coche.getId() == cliente.getId() && coche.getMatricula().equals(cliente.getMatricula())) {
                cocheExistente = true;
            }
        }
        if (!cocheExistente) {
            Coche nuevoCoche = new Coche();
            nuevoCoche.setId(cliente.getId());
            nuevoCoche.setMatricula(cliente.getMatricula());
            nuevoCoche.setMarca(cliente.getMarca());
            nuevoCoche.setModelo(cliente.getModelo());

            restTemplate.postForLocation("http://localhost:8080/coche", nuevoCoche);
        }

    }

    @Override
    public List<Cliente> listarclientes() {

        return restTemplate.getForObject("http://localhost:8080/coche", List.class);

    }

    @Override
    public Cliente obtenerPorId(int id) {
        return restTemplate.getForObject("http://localhost:8080/coche/" + id, Cliente.class);
    }

    @Override
    public void actualizar(Cliente cliente) {
        Coche[] coches = restTemplate.getForObject("http://localhost:8080/coche", Coche[].class);
        boolean cocheExistente = false;

        for (Coche coche : coches) {
            if (coche.getId() == cliente.getId() && coche.getMatricula().equals(cliente.getMatricula())) {
                cocheExistente = true;
                break; // Salir del bucle si encontramos el coche que coincide
            }
        }

        Coche cocheParaActualizar = new Coche();
        cocheParaActualizar.setId(cliente.getId());
        cocheParaActualizar.setMatricula(cliente.getMatricula());
        cocheParaActualizar.setMarca(cliente.getMarca());
        cocheParaActualizar.setModelo(cliente.getModelo());

        if (!cocheExistente) {
            // Si el coche ya existe, actualízalo
            restTemplate.put("http://localhost:8080/coche", cocheParaActualizar);

        }
    }

    public void eliminar(int id) {

        restTemplate.delete("http://localhost:8080/coche/" + id);
    }


    // -----------------------------------------Metodos para coche------------------------------------------------

    public void nuevoCoche(Coche coche) {

        Coche[] coches = restTemplate.getForObject("http://localhost:8080/coche", Coche[].class);
        boolean cocheExistente = false;
        for (Coche c : coches) {
            if (c.getId() == coche.getId() && c.getMatricula().equals(coche.getMatricula())) {
                cocheExistente = true;
            }

            if (!cocheExistente) {
                Coche nuevoCoche = new Coche();
                nuevoCoche.setId(coche.getId());
                nuevoCoche.setMatricula(coche.getMatricula());
                nuevoCoche.setMarca(coche.getMarca());
                nuevoCoche.setModelo(coche.getModelo());

                restTemplate.postForLocation("http://localhost:8080/coche", nuevoCoche);
            }

        }

    }

    public List<Coche> listarcoches() {

        return restTemplate.getForObject("http://localhost:8080/coche", List.class);
    }

    public Coche obtenerCochePorId(int id) {

        return restTemplate.getForObject("http://localhost:8080/coche/" + id, Coche.class);
    }

    public void actualizarCoche(Coche coche) {

        Coche[] coches = restTemplate.getForObject("http://localhost:8080/coche", Coche[].class);
        boolean cocheExistente = false;
        for (Coche c : coches) {
            if (c.getId() == coche.getId() && c.getMatricula().equals(coche.getMatricula())) {
                 cocheExistente = true;
            }
            if(!cocheExistente){

                Coche nuevoCoche = new Coche();
                nuevoCoche.setId(coche.getId());
                nuevoCoche.setMatricula(coche.getMatricula());
                nuevoCoche.setMarca(coche.getMarca());
                nuevoCoche.setModelo(coche.getModelo());
                restTemplate.put("http://localhost:8080/coche", nuevoCoche);
            }
        }
    }

    public void eliminarCoche(int id) { 
        restTemplate.delete("http://localhost:8080/coche/" + id);
    }

}
