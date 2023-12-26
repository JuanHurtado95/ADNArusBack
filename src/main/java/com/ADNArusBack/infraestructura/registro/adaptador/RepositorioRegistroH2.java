package com.ADNArusBack.infraestructura.registro.adaptador;

import com.ADNArusBack.dominio.registro.modelo.entidad.Registro;
import com.ADNArusBack.dominio.registro.puerto.repositorio.RepositorioRegistro;
import com.ADNArusBack.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ADNArusBack.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioRegistroH2 implements RepositorioRegistro {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="registro", value="crear")
    private static String sqlCrear;

    public RepositorioRegistroH2(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Registro registro) {
        return this.customNamedParameterJdbcTemplate.crear(registro, sqlCrear);
    }
}
