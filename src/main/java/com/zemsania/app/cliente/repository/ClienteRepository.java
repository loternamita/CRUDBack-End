package com.zemsania.app.cliente.repository;

import com.zemsania.app.cliente.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
    @Query("SELECT c FROM Cliente c WHERE c.tipoCedula = ?1 AND c.numeroCedula = ?2")
    Cliente findNumberByTypeNumber(String tipoCedula, String numeroCedula);
}
