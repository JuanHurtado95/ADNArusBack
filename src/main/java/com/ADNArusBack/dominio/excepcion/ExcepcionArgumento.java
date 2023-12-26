package com.ADNArusBack.dominio.excepcion;

public class ExcepcionArgumento extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionArgumento(String message) {
        super(message);
    }
}
