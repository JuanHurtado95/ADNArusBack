package com.ADNArusBack.infraestructura.registro.controlador;

import com.ADNArusBack.aplicacion.manejador.ComandoRespuesta;
import com.ADNArusBack.aplicacion.registro.comando.ComandoRegistro;
import com.ADNArusBack.aplicacion.registro.comando.manejador.ManejadorRegistro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registro")
public class ComandoControladorRegistro {

    private final ManejadorRegistro manejadorRegistro;

    @Autowired
    public ComandoControladorRegistro(ManejadorRegistro manejadorRegistro) {
        this.manejadorRegistro = manejadorRegistro;
    }

    @PostMapping
    public ComandoRespuesta<Long> registrar(@RequestBody ComandoRegistro comandoRegistro) {
        return manejadorRegistro.ejecutar(comandoRegistro);
    }

}
