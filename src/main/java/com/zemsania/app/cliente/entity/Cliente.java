package com.zemsania.app.cliente.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Table;
import lombok.*;
import javax.persistence.Id;

@Entity
@Table(name = "Cliente")
@Data
@NoArgsConstructor
public class Cliente implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name= "tipoCedula")
    private String tipoCedula;
    
    @Column(name= "numeroCedula")
    private String numeroCedula;
    
    @Column(name= "primerNombre")
    private String primerNombre;
    
    @Column(name= "segundoNombre")
    private String segundoNombre;
    
    @Column(name= "primerApellido")
    private String primerApellido;
    
    @Column(name= "segundoApellido")
    private String segundoApellido;
    
    @Column(name= "telefono")
    private String telefono;
    
    @Column(name= "direccion")
    private String direccion;
    
    @Column(name= "ciudadResidencia")
    private String ciudadResidencia;
}
