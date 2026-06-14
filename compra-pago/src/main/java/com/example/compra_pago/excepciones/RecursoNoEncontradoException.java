package com.example.compra_pago.excepciones;

public class RecursoNoEncontradoException extends RuntimeException {
    
    public RecursoNoEncontradoException(String mensaje) {

        super(mensaje);
    }
}
