package com.example.pelicula.exception;

import org.springframework.web.bind.annotation.*;

import feign.FeignException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.HashMap;
import java.util.Map;
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RecursoNoEncontradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> ManejarNoEncontrado(RecursoNoEncontradoException ex){
        Map<String, String> error = new HashMap<>();

        error.put("Error", ex.getMessage());
        return error;
    }
    @ExceptionHandler(FeignException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, String> manejarErrorGeneralFeign(FeignException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("Error", "No se pudo conectar con el microservicio externo: " + ex.getMessage());
        return error;
    }
    @ExceptionHandler(FeignException.NotFound.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> manejarFeignNotFound(FeignException.NotFound ex) {
        Map<String, String> error = new HashMap<>();
        error.put("Error", "El ID provisto no existe en el microservicio externo.");
        return error;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> manejarValidaciones(MethodArgumentNotValidException ex){
        Map<String, String> errores = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error ->{
            errores.put(error.getField(), error.getDefaultMessage());
        });
        return errores;
    }
}