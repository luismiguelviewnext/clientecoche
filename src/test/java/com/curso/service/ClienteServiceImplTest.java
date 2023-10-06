package com.curso.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import java.util.Optional;

import com.curso.dao.ClienteDao;
import com.curso.model.Cliente;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceImplTest {

    private static final String COCHE_URL = "http://localhost:8080/coche";
    @Mock
    private ClienteDao clienteDao;
    @Mock
    private RestTemplate restTemplate;
    @InjectMocks
    private ClienteServiceImpl clienteService;

    @Test
    public void testNuevoCliente() {
        Cliente cliente = new Cliente();
        clienteService.nuevoCliente(cliente);

        verify(clienteDao, times(1)).save(cliente);
    }

    @Test
    public void testListarClientes(){
        when(clienteDao.findAll()).thenReturn(Arrays.asList(new Cliente(), new Cliente()));

        assertEquals(2, clienteService.listarclientes().size());
    }

    @Test
    public void testObtenerPorId() {

        Cliente cliente = new Cliente();
        when(clienteDao.findById(1)).thenReturn(Optional.of(cliente));

        Cliente result = clienteService.obtenerPorId(1);
        assertEquals(cliente, result);
    }

    @Test
    public void testActualizar() {

        Cliente cliente = new Cliente();
        clienteService.nuevoCliente(cliente);

        verify(clienteDao, times(1)).save(cliente);

    }

    @Test
    public void testEliminar() {
        clienteService.eliminar(1);
        verify(clienteDao, times(1)).deleteById(1);
    }

}
