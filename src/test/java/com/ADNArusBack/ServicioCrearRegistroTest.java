package com.ADNArusBack;

import com.ADNArusBack.dominio.registro.puerto.repositorio.RepositorioRegistro;
import com.ADNArusBack.dominio.registro.servicio.ServicioCrearRegistro;
import com.ADNArusBack.testdatabuilder.RegistroTestDataBuilder;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ServicioCrearRegistroTest {
    private static final String SE_DEBE_CORREGIR_EL_DOCUMENTO = "Corrija el numero de documento ingresado";
    private static final String SOLO_DEBEN_CONTENER_LETRAS = "Debe corregir el su nombre completo solo contenga letras";
    private static final String CRITERIO_1 ="Para la administradora de pension AFP003 solo es posible afiliarse despues de 2020/12/31";


    private static final String CRITERIO_2 ="Para una persona con tipo de documento RC Registro civil no es permitido afiliarse a las EPS: EPS003, EPS004";
    private static final String CRITERIO_3 ="Las personas que se afilien a la administradora EPS002 Sura EPS solo pueden afiliarse a la administradora de pension AFP001 Proteccion";

    @Mock
    private RepositorioRegistro repositorioRegistro;

    @InjectMocks
    private ServicioCrearRegistro servicioCrearRegistro;

    @Test
    public void validarCriterio1() throws ParseException {

        try {
            // arrange
            RegistroTestDataBuilder registroTestDataBuilder = new RegistroTestDataBuilder().conAdministradoraPension("AFP003").conFechaPension(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2019"));
            // act - assert
            ServicioCrearRegistro servicioCrearRegistro = new ServicioCrearRegistro(repositorioRegistro);
        }catch(Exception e){
            Assert.assertTrue(e.getMessage().equals(CRITERIO_1));
        }
    }

    @Test
    public void validarCriterio2() {
        try {
            // arrange
            RegistroTestDataBuilder registroTestDataBuilder = new RegistroTestDataBuilder().conTipoDocumento("RC").conAdministradoraSalud("EPS003");

            // act - assert
            ServicioCrearRegistro servicioCrearRegistro = new ServicioCrearRegistro(repositorioRegistro);
        }catch(Exception e){
            Assert.assertTrue(e.getMessage().equals(CRITERIO_2));
        }
    }

    @Test
    public void validarCriterio3() {
        try {
            // arrange
            RegistroTestDataBuilder registroTestDataBuilder = new RegistroTestDataBuilder().conAdministradoraSalud("EPS002").conAdministradoraPension("AFP003");

            // act - assert
            ServicioCrearRegistro servicioCrearRegistro = new ServicioCrearRegistro(repositorioRegistro);
        }catch(Exception e){
            Assert.assertTrue(e.getMessage().equals(CRITERIO_3));
        }
    }

    @Test
    public void registroDocumentoErroneo() {
        try {
            // arrange
            RegistroTestDataBuilder registroTestDataBuilder = new RegistroTestDataBuilder().conTipoDocumento("CC").conDocumento("-123134345");

            // act - assert
            ServicioCrearRegistro servicioCrearRegistro = new ServicioCrearRegistro(repositorioRegistro);
        }catch(Exception e){
            Assert.assertTrue(e.getMessage().equals(SE_DEBE_CORREGIR_EL_DOCUMENTO));
        }
    }

    @Test
    public void registroNombreErroneo() {
        try {
            // arrange
            RegistroTestDataBuilder registroTestDataBuilder = new RegistroTestDataBuilder().conPrimerNombre("Ju4n");

            // act - assert
            ServicioCrearRegistro servicioCrearRegistro = new ServicioCrearRegistro(repositorioRegistro);
        }catch(Exception e){
            Assert.assertTrue(e.getMessage().equals(SOLO_DEBEN_CONTENER_LETRAS));
        }
    }
}
