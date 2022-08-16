package com.api.combodigital.controllers;

import com.api.combodigital.entities.Cuenta;
import com.api.combodigital.entities.Suscripcion;
import com.api.combodigital.services.ICuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

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
        Optional<Cuenta> cuentaEncontrada = iCuentaService.consultarCuenta(id);
        if (cuentaEncontrada.isPresent()){
            return new ResponseEntity<>(cuentaEncontrada.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @PostMapping("agregar/cuenta")
    ResponseEntity<?> agregar(@RequestBody Cuenta cuenta) {
        return new ResponseEntity<>(iCuentaService.agregarCuenta(cuenta),HttpStatus.CREATED);
    }

    @PutMapping("editar/cuenta")
    ResponseEntity<Cuenta> editar(@RequestBody Cuenta cuenta) {
        Optional<Cuenta> cuentaEncontrada = iCuentaService.consultarCuenta(cuenta.getId());
        if (cuentaEncontrada.isPresent()){
            return new ResponseEntity<>(iCuentaService.editarCuenta(cuenta),HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @DeleteMapping("eliminar/cuenta/{id}")
    ResponseEntity<Void> eliminar(@PathVariable Long id){
        Optional<Cuenta> cuentaEncontrada = iCuentaService.consultarCuenta(id);
        if (cuentaEncontrada.isPresent()){
            iCuentaService.eliminar(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @GetMapping("consultar/cuenta/{id}/suscripcion")
    ResponseEntity<Collection<Suscripcion>> suscripcionCuenta(@PathVariable Long id)
    {
        Optional<Cuenta> cuentaOptional= iCuentaService.consultarCuenta(id);
        if(cuentaOptional.isPresent()){
            return new ResponseEntity<>( cuentaOptional.get().getSuscripcion(),HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
