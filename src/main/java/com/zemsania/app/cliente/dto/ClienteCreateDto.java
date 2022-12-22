package com.zemsania.app.cliente.dto;

import com.zemsania.app.cliente.entity.Cliente;
import lombok.Data;

@Data
public class ClienteCreateDto {
    private String tipoCedula;
    private String numeroCedula;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String telefono;
    private String direccion;
    private String ciudadResidencia;

    public ClienteCreateDto() {
    }
    
    public ClienteCreateDto(Cliente cliente) {
        this.tipoCedula = cliente.getTipoCedula();
        this.numeroCedula = cliente.getNumeroCedula();
        this.primerNombre = cliente.getPrimerNombre();
        this.segundoNombre = cliente.getSegundoNombre();
        this.primerApellido = cliente.getPrimerApellido();
        this.segundoApellido = cliente.getSegundoApellido();
        this.telefono = cliente.getTelefono();
        this.direccion = cliente.getDireccion();
        this.ciudadResidencia = cliente.getCiudadResidencia();
    }   
}
