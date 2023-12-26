package com.ADNArusBack.aplicacion.registro.comando.manejador;

import com.ADNArusBack.aplicacion.manejador.ComandoRespuesta;
import com.ADNArusBack.aplicacion.manejador.ManejadorComandoRespuesta;
import com.ADNArusBack.aplicacion.registro.comando.ComandoRegistro;
import com.ADNArusBack.aplicacion.registro.comando.fabrica.FabricaRegistro;
import com.ADNArusBack.dominio.registro.modelo.entidad.Registro;
import com.ADNArusBack.dominio.registro.servicio.ServicioCrearRegistro;
import org.springframework.stereotype.Component;


@Component
public class ManejadorRegistro implements ManejadorComandoRespuesta<ComandoRegistro, ComandoRespuesta<Long>> {

    private final FabricaRegistro fabricaRegistro;
    private final ServicioCrearRegistro servicioCrearRegistro;

    public ManejadorRegistro(FabricaRegistro fabricaRegistro, ServicioCrearRegistro servicioCrearRegistro) {
        this.fabricaRegistro = fabricaRegistro;
        this.servicioCrearRegistro = servicioCrearRegistro;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoRegistro comandoRegistro) {
        Registro registro = this.fabricaRegistro.crear(comandoRegistro);
        return new ComandoRespuesta<>(this.servicioCrearRegistro.ejecutar(registro));
    }
}
