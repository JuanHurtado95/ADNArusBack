package com.ADNArusBack.infraestructura.registro.configuracion;

import com.ADNArusBack.dominio.registro.puerto.repositorio.RepositorioRegistro;
import com.ADNArusBack.dominio.registro.servicio.ServicioCrearRegistro;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {
    @Bean
    public ServicioCrearRegistro servicioCrearRegistro(RepositorioRegistro repositorioRegistro){
        return new ServicioCrearRegistro(repositorioRegistro);
    }
}
