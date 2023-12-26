package com.ADNArusBack.dominio.registro.modelo.entidad;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

import static com.ADNArusBack.dominio.ValidarArgumento.*;

@Getter
@Setter
public class Registro {

    private static final String SE_DEBE_INGRESAR_TIPO_IDENTIDICACION = "Se debe ingresar el tipo de identificacion";
    private static final String SE_DEBE_INGRESAR_IDENTIDICACION = "Se debe ingresar la identificacion";
    private static final String SE_DEBE_INGRESAR_PRIMER_NOMBRE = "Se debe ingresar el nombre";
    private static final String SE_DEBE_INGRESAR_PRIMER_APELLIDO = "Se debe ingresar el apellido";
    private static final String SE_DEBE_INGRESAR_TIPO_EPS = "Se debe ingresar el tipo de administradora de EPS";
    private static final String SE_DEBE_INGRESAR_FECHA_EPS = "Se debe ingresar la fecha de registro de EPS";
    private static final String SE_DEBE_INGRESAR_TIPO_PENSION = "Se debe ingresar el tipo de administradora de pension";
    private static final String SE_DEBE_INGRESAR_FECHA_PENSION = "Se debe ingresar la fecha de registro de pension";
    private static final String SE_DEBE_CORREGIR_EL_DOCUMENTO = "Corrija el numero de documento ingresado";
    private static final String SOLO_DEBEN_CONTENER_LETRAS = "Debe corregir el su nombre completo solo contenga letras";

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

    public Registro(Long id, String tipoDocumento, String numeroDocumento, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String administradoraSalud, Date fechaAfiliacionSalud, String administradoraPension, Date fechaAfiliacionPension) {

        validarObligatorio(tipoDocumento, SE_DEBE_INGRESAR_TIPO_IDENTIDICACION);
        validarObligatorio(numeroDocumento, SE_DEBE_INGRESAR_IDENTIDICACION);
        validarObligatorio(primerNombre, SE_DEBE_INGRESAR_PRIMER_NOMBRE);
        validarObligatorio(primerApellido, SE_DEBE_INGRESAR_PRIMER_APELLIDO);
        validarObligatorio(administradoraSalud, SE_DEBE_INGRESAR_TIPO_EPS);
        validarObligatorio(fechaAfiliacionSalud, SE_DEBE_INGRESAR_FECHA_EPS);
        validarObligatorio(administradoraPension, SE_DEBE_INGRESAR_TIPO_PENSION);
        validarObligatorio(fechaAfiliacionPension, SE_DEBE_INGRESAR_FECHA_PENSION);

        validarDocumento(numeroDocumento, tipoDocumento, SE_DEBE_CORREGIR_EL_DOCUMENTO);
        validarNombre(primerNombre, SOLO_DEBEN_CONTENER_LETRAS);
        validarNombre(segundoNombre, SOLO_DEBEN_CONTENER_LETRAS);
        validarNombre(primerApellido, SOLO_DEBEN_CONTENER_LETRAS);
        validarNombre(segundoApellido, SOLO_DEBEN_CONTENER_LETRAS);


        this.id = id;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.administradoraSalud = administradoraSalud;
        this.fechaAfiliacionSalud = fechaAfiliacionSalud;
        this.administradoraPension = administradoraPension;
        this.fechaAfiliacionPension = fechaAfiliacionPension;
    }
}
