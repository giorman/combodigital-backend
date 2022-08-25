package com.api.combodigital.controllers;

import com.api.combodigital.entities.Cliente;
import com.api.combodigital.entities.Suscripcion;
import com.api.combodigital.services.ISuscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("api/combodigital/")
public class SuscripcionController {
    @Autowired
    private ISuscripcionService iSuscripcionService;

    @GetMapping("lista/suscripcion")
    private ResponseEntity<Collection<Suscripcion>> lista(){
        return new ResponseEntity<>( iSuscripcionService.listaSuscripcion(), HttpStatus.OK);
    }

    @GetMapping("consultar/suscripcion/{id}")
    private ResponseEntity<Suscripcion> consultar(@PathVariable Long id){
            return new ResponseEntity<>(iSuscripcionService.consultarSuscripcion(id),HttpStatus.OK);
    }

    @PostMapping("agregar/suscripcion")
    private ResponseEntity<Suscripcion> agregar(@RequestBody Suscripcion suscripcion){
        return new ResponseEntity<>(iSuscripcionService.agregarSuscripcion(suscripcion),HttpStatus.CREATED);

    }

    @PutMapping("editar/suscripcion")
    private ResponseEntity<Suscripcion> editar(@RequestBody Suscripcion suscripcion){
        return new ResponseEntity<>(iSuscripcionService.editarSuscripcion(suscripcion),HttpStatus.CREATED);
    }

    @DeleteMapping("eliminar/suscripcion/{id}")
    private ResponseEntity<Void> eliminar(@PathVariable Long id){
        iSuscripcionService.eliminarSuscripcion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("consultar/renovaciones")
    private ResponseEntity<Collection<Suscripcion>> renovaciones(){
            return new ResponseEntity<>(iSuscripcionService.listaSuscripcionRenovaciones(),HttpStatus.OK);
    }

    @GetMapping("consultar/vencidas")
    private ResponseEntity<Collection<Suscripcion>> vencidas(){
        return new ResponseEntity<>(iSuscripcionService.listaSuscripcionVencidas(),HttpStatus.OK);
    }



}
