package com.zemsania.app.cliente.dto;

import com.zemsania.app.cliente.entity.Cliente;
import lombok.Data;

@Data
public class ClienteDto {
    
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String telefono;
    private String direccion;
    private String ciudadResidencia;

    public ClienteDto() { 
    }
    
    public ClienteDto(Cliente cliente) {
        
        this.primerNombre = cliente.getPrimerNombre();
        this.segundoNombre = cliente.getSegundoNombre();
        this.primerApellido = cliente.getPrimerApellido();
        this.segundoApellido = cliente.getSegundoApellido();
        this.telefono = cliente.getTelefono();
        this.direccion = cliente.getDireccion();
        this.ciudadResidencia = cliente.getCiudadResidencia();
    }
}
