package com.ADNArusBack.aplicacion.registro.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoRegistro {

    private Long id;
    private String tipoDocumento;
    private String numeroDocumento;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String administradoraSalud;
    private Date fechaAfiliacionSalud;
    private String administradoraPension;
    private Date fechaAfiliacionPension;
}
