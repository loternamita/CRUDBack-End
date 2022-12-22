package com.zemsania.app.cliente.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class response<T> {
    
    private int code;
    private String messageCode;
    private Object cliente;

    public response(int code, String messageCode) {
        this.code = code;
        this.messageCode = messageCode;
    }
    
    public response(int code, String messageCode, T body) {
        this.code = code;
        this.messageCode = messageCode;
        this.cliente = body;
    }
}
