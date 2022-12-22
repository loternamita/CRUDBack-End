package com.zemsania.app.cliente.service;

import com.zemsania.app.cliente.dto.ClienteCreateDto;
import com.zemsania.app.cliente.entity.Cliente;
import java.util.List;
import java.util.Optional;


public interface ClienteService {
    
    public List<Cliente> findAll();
    public Cliente findByNumeroAndTipo(String tipoCedula, String numeroCedula);
    public Optional<Cliente> findById (Long id);
    public Cliente saveClient(Cliente clienteCreate);
    public Cliente updateClient(Cliente clienteUpdate, Long id);
    public void deleteClient(Long id);
}
