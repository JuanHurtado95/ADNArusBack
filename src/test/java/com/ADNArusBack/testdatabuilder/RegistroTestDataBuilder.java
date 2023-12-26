package com.ADNArusBack.testdatabuilder;

import com.ADNArusBack.dominio.registro.modelo.entidad.Registro;

import java.util.Date;

public class RegistroTestDataBuilder {

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

    public RegistroTestDataBuilder(){
        tipoDocumento="CC";
        numeroDocumento="1116266260";
        primerNombre="Juan";
        segundoNombre="Carlos";
        primerApellido="Hurtado";
        segundoApellido="Sarria";
        administradoraSalud="EPS002";
        fechaAfiliacionSalud= new Date(2023-12-12);
        administradoraPension="AFP003";
        fechaAfiliacionPension= new Date(2021-12-12);
    }

    public RegistroTestDataBuilder conTipoDocumento(String tipoDocumento){
        this.tipoDocumento = tipoDocumento;
        return this;
    }

    public RegistroTestDataBuilder conDocumento(String numeroDocumento){
        this.numeroDocumento = numeroDocumento;
        return this;
    }

    public RegistroTestDataBuilder conPrimerNombre(String primerNombre){
        this.primerNombre = primerNombre;
        return this;
    }

    public RegistroTestDataBuilder conSegundoNombre(String segundoNombre){
        this.segundoNombre = segundoNombre;
        return this;
    }

    public RegistroTestDataBuilder conPrimerApellido(String primerApellido){
        this.primerApellido = primerApellido;
        return this;
    }

    public RegistroTestDataBuilder conSegundoApellido(String segundoApellido){
        this.segundoApellido = segundoApellido;
        return this;
    }

    public RegistroTestDataBuilder conAdministradoraSalud(String administradoraSalud){
        this.administradoraSalud = administradoraSalud;
        return this;
    }

    public RegistroTestDataBuilder conFechaSalud(Date fechaAfiliacionSalud){
        this.fechaAfiliacionSalud = fechaAfiliacionSalud;
        return this;
    }

    public RegistroTestDataBuilder conAdministradoraPension(String administradoraPension){
        this.administradoraPension = administradoraPension;
        return this;
    }

    public RegistroTestDataBuilder conFechaPension(Date fechaAfiliacionPension){
        this.fechaAfiliacionPension = fechaAfiliacionPension;
        return this;
    }
    public Registro build(){
        return new Registro(1l, tipoDocumento, numeroDocumento, primerNombre, segundoNombre, primerApellido,
                segundoApellido, administradoraSalud, fechaAfiliacionSalud, administradoraPension, fechaAfiliacionPension);
    }
}
