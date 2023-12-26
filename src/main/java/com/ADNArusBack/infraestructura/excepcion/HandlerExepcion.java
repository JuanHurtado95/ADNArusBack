package com.ADNArusBack.infraestructura.excepcion;

import com.ADNArusBack.dominio.excepcion.ExcepcionArgumento;
import org.drools.runtime.rule.ConsequenceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.concurrent.ConcurrentHashMap;

@ControllerAdvice
public class HandlerExepcion extends ResponseEntityExceptionHandler {

    private final static Logger LOGGER = LoggerFactory.getLogger(HandlerExepcion.class);
    private static final String OCURRIO_UN_ERROR_FAVOR_CONTACTAR_AL_ADMINISTRADOR =
            "Ocurrió un error favor contactar al administrador.";
    private static final ConcurrentHashMap<String, Integer> STATUS_CODE = new ConcurrentHashMap<>();

    public HandlerExepcion() {
        STATUS_CODE.put(ExcepcionArgumento.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        STATUS_CODE.put(ConsequenceException.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<APIExcepcion> handleAllExceptions(Exception exception) {

        ResponseEntity<APIExcepcion> result;

            String excepcionNombre = exception.getClass().getSimpleName();
        String mensaje = exception.getCause() == null ? exception.getMessage() : exception.getCause().getMessage();
        Integer codigo = STATUS_CODE.get(excepcionNombre);
        if (codigo != null) {
            APIExcepcion error = new APIExcepcion(codigo, mensaje);
            result = new ResponseEntity<>(error, HttpStatus.valueOf(codigo));
        } else {
            APIExcepcion error = new APIExcepcion(codigo, OCURRIO_UN_ERROR_FAVOR_CONTACTAR_AL_ADMINISTRADOR);
            result = new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        LOGGER.error("{0}", exception);
        return result;
    }

}
