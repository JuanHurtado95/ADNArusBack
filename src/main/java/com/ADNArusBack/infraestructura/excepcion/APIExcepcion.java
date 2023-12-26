package com.ADNArusBack.infraestructura.excepcion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class APIExcepcion {

    private int excepcion;
    private String mensaje;
}