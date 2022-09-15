package com.api.combodigital.controllers;

import com.api.combodigital.entities.Ganancia;
import com.api.combodigital.services.IGananciaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("api/combodigital/")
@Api(tags = "Controlador Ganancia")
public class GananciaController {

    @Autowired
    private IGananciaService iGananciaService;

    @GetMapping("lista/ganancia")
    @ApiOperation("consultar lista ganancias")
    ResponseEntity<Collection<Ganancia>> listaGanancia(){
        return new ResponseEntity<>(iGananciaService.listaGanancia(), HttpStatus.OK);
    }

    @PutMapping("valor/ganancia/{valor}")
    @ApiOperation("permite agregar mas ganancia al mes")
    ResponseEntity<Collection<Ganancia>> editarValorGanancia(@PathVariable Double valor){
            return new ResponseEntity<>(iGananciaService.editarValorGanancia(valor),HttpStatus.OK);
    }
}
