package com.example.compra_pago.excepciones;


import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

@ExceptionHandler(RecursoNoEncontradoException.class)
@ResponseStatus(HttpStatus.NOT_FOUND)

public Map<String, String> manejarNoEncontrado(RecursoNoEncontradoException ex) {
            Map<String, String> error = new HashMap<>();
            error.put("mensaje", ex.getMessage());

        return error;
    }

@ExceptionHandler(MethodArgumentNotValidException.class)
@ResponseStatus(HttpStatus.BAD_REQUEST)
public Map<String, String> manejarValidaciones(MethodArgumentNotValidException ex) {
    Map<String, String> errores = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errores.put(error.getField(), error.getDefaultMessage());

        });
        return errores;
    }

}



