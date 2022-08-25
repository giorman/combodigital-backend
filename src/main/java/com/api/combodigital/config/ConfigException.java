package com.api.combodigital.config;


import com.api.combodigital.entities.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice(annotations = RestController.class)
public class ConfigException {
    @Autowired
    Mensaje mensaje;

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> notFoundException(Exception e){
        mensaje.setMensaje(e.getMessage());
        return new ResponseEntity<>(mensaje,HttpStatus.NOT_FOUND);
    }
}
