package com.api.combodigital.controllers;

import com.api.combodigital.entities.Cuenta;
import com.api.combodigital.entities.Suscripcion;
import com.api.combodigital.services.ICuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("api/combodigital/")
public class CuentaController {

    @Autowired
    ICuentaService iCuentaService;

    @GetMapping("lista/cuenta")
    ResponseEntity<Collection<Cuenta>> lista(){
        return new ResponseEntity<>(iCuentaService.listaCuenta(), HttpStatus.OK);
    }

    @GetMapping("consultar/cuenta/{id}")
    ResponseEntity<Cuenta> consultar(@PathVariable Long id){
            return new ResponseEntity<>(iCuentaService.consultarCuenta(id),HttpStatus.OK);
    }

    @PostMapping("agregar/cuenta")
    ResponseEntity<Cuenta> agregar(@RequestBody Cuenta cuenta) {
        return new ResponseEntity<>(iCuentaService.agregarCuenta(cuenta),HttpStatus.CREATED);
    }

    @PutMapping("editar/cuenta")
    ResponseEntity<Cuenta> editar(@RequestBody Cuenta cuenta) {
            return new ResponseEntity<>(iCuentaService.editarCuenta(cuenta),HttpStatus.OK);
    }

    @DeleteMapping("eliminar/cuenta/{id}")
    ResponseEntity<Void> eliminar(@PathVariable Long id){
            iCuentaService.eliminar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("consultar/cuenta/{id}/suscripcion")
    ResponseEntity<Collection<Suscripcion>> suscripcionCuenta(@PathVariable Long id)
    {
        return new ResponseEntity<>(iCuentaService.consultarCuenta(id).getSuscripcion(),HttpStatus.OK);
    }
}
