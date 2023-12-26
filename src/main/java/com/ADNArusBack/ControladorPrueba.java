package com.ADNArusBack;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorPrueba {

    @GetMapping("ejemplo")
    public String obtenerEjemplo() {

        return "prueba";
    }
}
