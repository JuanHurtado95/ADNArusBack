package com.ADNArusBack.dominio.registro.servicio;

import com.ADNArusBack.dominio.registro.modelo.entidad.Registro;
import com.ADNArusBack.dominio.registro.puerto.repositorio.RepositorioRegistro;

import static com.ADNArusBack.dominio.drools.ReglasValidacion.validarCriterios;

public class ServicioCrearRegistro {

    private final RepositorioRegistro repositorioRegistro;

    public ServicioCrearRegistro(RepositorioRegistro repositorioRegistro) {
        this.repositorioRegistro = repositorioRegistro;
    }

    public Long ejecutar(Registro registro) {
        validarCriterios(registro);
        return this.repositorioRegistro.crear(registro);
    }
}
