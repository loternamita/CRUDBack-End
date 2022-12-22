package com.zemsania.app.cliente.service.impl;

import com.zemsania.app.cliente.entity.Cliente;
import com.zemsania.app.cliente.service.impl.ClienteServiceImpl;
import com.zemsania.app.cliente.repository.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doReturn;
import org.mockito.MockitoAnnotations;

public class ClienteServiceImplTest {

    @Mock
    private ClienteRepository clienteRepository;

    /*@InjectMocks
    private ClienteController clienteController;*/
    @InjectMocks
    private ClienteServiceImpl clienteServiceImpl;
    private Cliente cliente;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        cliente = new Cliente();
        cliente.setPrimerNombre("Brayan");
        cliente.setSegundoNombre("Camilo");
        cliente.setPrimerApellido("Vargas");
        cliente.setSegundoApellido("Trial");
        cliente.setTelefono("3144203149");
        cliente.setDireccion("calle nodal # 13 - 69");
        cliente.setCiudadResidencia("Cali");
    }

    @Test
    public void testFindByNumeroAndTipo() {
        String tipoCedula = "P";
        String numeroCedula = "23445322";
        boolean validateEquals = false;

        doReturn(cliente).when(clienteRepository).findNumberByTypeNumber(tipoCedula, numeroCedula);
        cliente = clienteServiceImpl.findByNumeroAndTipo(tipoCedula, numeroCedula);
        assertNotNull(cliente);
        if ("P".equals(tipoCedula) || "C".equals(tipoCedula)) {
            validateEquals = true;
        }
        assertTrue(validateEquals);

        
        
        

    }
}
