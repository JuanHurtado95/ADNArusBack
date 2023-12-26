package com.ADNArusBack.aplicacion.manejador;

import org.springframework.transaction.annotation.Transactional;

public interface ManejadorComandoRespuesta<C, R> {

    @Transactional
    R ejecutar(C comando);
}
