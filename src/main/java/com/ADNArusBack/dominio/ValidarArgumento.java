package com.ADNArusBack.dominio;

import com.ADNArusBack.dominio.excepcion.ExcepcionArgumento;

public class ValidarArgumento {

    public static void validarObligatorio(Object valor, String mensaje) {
        if (valor == null || valor.toString().trim().isEmpty()) {
            throw new ExcepcionArgumento(mensaje);
        }
    }

    public static void validarNombre(Object valor, String mensaje){
        String nombre = (String) valor;
        if(!nombre.matches("^[a-zA-Z]+$")){
            throw new ExcepcionArgumento(mensaje);
        }
    }

    public static void validarDocumento(Object documento, Object tipo, String mensaje){
        String numeroDocumento = (String) documento;

        if (tipo == "CC") {
            if (numeroDocumento.length() > 10 || !numeroDocumento.matches("^\\d+$")) {
                throw new ExcepcionArgumento(mensaje);
            }
        }

        if (tipo == "RC" || tipo == "TI") {
            if (!numeroDocumento.matches("^\\d+$")) {
                throw new ExcepcionArgumento(mensaje);
            }
        }

        if (tipo == "CE") {
            if (!numeroDocumento.matches("^[a-zA-Z0-9]+$")) {
                throw new ExcepcionArgumento(mensaje);
            }
        }
    }
}
