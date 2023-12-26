package com.ADNArusBack.aplicacion.registro.comando.fabrica;

import com.ADNArusBack.aplicacion.registro.comando.ComandoRegistro;
import com.ADNArusBack.dominio.registro.modelo.entidad.Registro;
import org.springframework.stereotype.Component;

@Component
public class FabricaRegistro {

    public Registro crear(ComandoRegistro comandoRegistro) {
        return new Registro(
                comandoRegistro.getId(),
                comandoRegistro.getTipoDocumento(),
                comandoRegistro.getNumeroDocumento(),
                comandoRegistro.getPrimerNombre(),
                comandoRegistro.getSegundoNombre(),
                comandoRegistro.getPrimerApellido(),
                comandoRegistro.getSegundoApellido(),
                comandoRegistro.getAdministradoraSalud(),
                comandoRegistro.getFechaAfiliacionSalud(),
                comandoRegistro.getAdministradoraPension(),
                comandoRegistro.getFechaAfiliacionPension()
        );
    }

}
