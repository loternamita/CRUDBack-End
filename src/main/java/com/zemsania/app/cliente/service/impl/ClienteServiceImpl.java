package com.zemsania.app.cliente.service.impl;

import com.zemsania.app.cliente.dto.ClienteCreateDto;
import com.zemsania.app.cliente.entity.Cliente;
import com.zemsania.app.cliente.repository.ClienteRepository;
import com.zemsania.app.cliente.service.ClienteService;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class ClienteServiceImpl implements ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        List<Cliente> c = (List<Cliente>) clienteRepository.findAll();
        return c;
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findByNumeroAndTipo(String tipoCedula, String numeroCedula) {
        log.info("Log pasa buscar por numero y tipo de cedula");
        return clienteRepository.findNumberByTypeNumber(tipoCedula, numeroCedula);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<Cliente> findById(Long id) {
        log.info("Log pasa IMPL");
        return clienteRepository.findById(id);
    }
    
    @Override
    public Cliente saveClient(Cliente clienteCreate){
        log.info("Save Client");
        return clienteRepository.save(clienteCreate);
    }
    
    @Override
    public Cliente updateClient(Cliente clienteUpdate, Long id){
        if(!clienteRepository.findById(id).isPresent()){
            return null;
        }
        log.info("Update Client");
        clienteUpdate.setId(id);
        return clienteRepository.save(clienteUpdate);
    }
    
    @Override
    public void deleteClient(Long id){
        if(!"".equals(id)){
            log.info("Update Client");
            clienteRepository.deleteById(id);
        }
    }
}
