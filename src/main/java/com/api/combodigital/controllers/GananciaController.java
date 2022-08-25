package com.api.combodigital.controllers;

import com.api.combodigital.entities.Ganancia;
import com.api.combodigital.services.IGananciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("api/combodigital/")
public class GananciaController {

    @Autowired
    private IGananciaService iGananciaService;

    @GetMapping("lista/ganancia")
    ResponseEntity<Collection<Ganancia>> listaGanancia(){
        return new ResponseEntity<>(iGananciaService.listaGanancia(), HttpStatus.OK);
    }

    @PutMapping("valor/ganancia/{valor}")
    ResponseEntity<Collection<Ganancia>> editarValorGanancia(@PathVariable Double valor){
            return new ResponseEntity<>(iGananciaService.editarValorGanancia(valor),HttpStatus.OK);
    }
}
