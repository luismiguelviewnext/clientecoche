package com.curso.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.curso.dao.ClienteDao;
import com.curso.model.Cliente;
import com.curso.model.Coche;

/**
 * Implementación del servicio ClienteService que gestiona las operaciones CRUD
 * para la entidad Cliente y las peticiones a Coche.
 * @author Luis Miguel Albarracín Castillo
 */
@Service
public class ClienteServiceImpl implements ClienteService {

    private static final String COCHE_URL = "http://localhost:8080/coche";

    /** DAO para operaciones con la entidad Cliente. */
    @Autowired
    ClienteDao clienteDao;

    /** RestTemplate para llamadas a otros servicios o microservicios. */
    @Autowired
    RestTemplate restTemplate;

    /**
     * Almacena un nuevo cliente en la base de datos.
     * 
     * @param cliente Cliente a almacenar.
     */
    @Override
    public void nuevoCliente(Cliente cliente) {
        clienteDao.save(cliente);
    }

    /**
     * Obtiene la lista de todos los clientes almacenados en la base de datos.
     * 
     * @return Lista de clientes.
     */
    @Override
    public List<Cliente> listarclientes() {
        return clienteDao.findAll();
    }

    /**
     * Obtiene un cliente específico por su ID.
     * 
     * @param id ID del cliente.
     * @return El cliente con el ID especificado o null si no se encuentra.
     */
    @Override
    public Cliente obtenerPorId(int id) {
        return clienteDao.findById(id).orElse(null);
    }

    /**
     * Actualiza la información de un cliente existente en la base de datos.
     * 
     * @param cliente Cliente con la información actualizada.
     */
    @Override
    public void actualizar(Cliente cliente) {
        clienteDao.save(cliente);
    }

    /**
     * Elimina un cliente específico por su ID de la base de datos.
     * 
     * @param id ID del cliente a eliminar.
     */
    public void eliminar(int id) {
        clienteDao.deleteById(id);
    }

    // -----------------------------------------Metodos para coche------------------------------------------------

    /**
     * Método para agregar un nuevo coche. Si el coche ya existe (basado en ID y
     * matrícula),
     * no se agregará un nuevo coche.
     * 
     * @param coche Coche a agregar.
     */
    public void nuevoCoche(Coche coche) {

        Coche[] coches = restTemplate.getForObject(COCHE_URL, Coche[].class);
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

                restTemplate.postForLocation(COCHE_URL, nuevoCoche);
            }

        }

    }

    /**
     * Obtiene una lista de todos los coches.
     * 
     * @return Lista de coches.
     */
    public List<Coche> listarcoches() {

        return restTemplate.getForObject(COCHE_URL, List.class);
    }

    /**
     * Obtiene un coche específico por su ID.
     * 
     * @param id ID del coche.
     * @return El coche con el ID especificado.
     */
    public Coche obtenerCochePorId(int id) {

        return restTemplate.getForObject(COCHE_URL + "/" + id, Coche.class);
    }

    /**
     * Actualiza la información de un coche existente. Si el coche no existe (basado
     * en ID y matrícula),
     * se crea uno nuevo.
     * 
     * @param coche Coche con la información actualizada.
     */
    public void actualizarCoche(Coche coche) {

        Coche[] coches = restTemplate.getForObject(COCHE_URL, Coche[].class);
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
                restTemplate.put(COCHE_URL, nuevoCoche);
            }
        }
    }

    /**
     * Elimina un coche específico por su ID.
     * 
     * @param id ID del coche a eliminar.
     */
    public void eliminarCoche(int id) {
        restTemplate.delete(COCHE_URL + "/" + id);
    }
}
