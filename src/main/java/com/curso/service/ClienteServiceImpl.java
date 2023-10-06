package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.curso.dao.ClienteDao;
import com.curso.model.Cliente;
import com.curso.model.Coche;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteDao clienteDao;
    @Autowired
    RestTemplate restTemplate;

    @Override
    public void nuevoCliente(Cliente cliente) {
       clienteDao.save(cliente);
    }

    @Override
    public List<Cliente> listarclientes() {

        return clienteDao.findAll();

    }

    @Override
    public Cliente obtenerPorId(int id) {
        return clienteDao.findById(id).orElse(null);
    }
    @Override
    public void actualizar(Cliente cliente) {
        clienteDao.save(cliente);
    }

    public void eliminar(int id) {

        clienteDao.deleteById(id);
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
