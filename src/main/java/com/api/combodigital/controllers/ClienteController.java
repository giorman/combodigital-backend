package com.api.combodigital.controllers;

import com.api.combodigital.entities.Cliente;
import com.api.combodigital.entities.Suscripcion;
import com.api.combodigital.services.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/combodigital/")
public class ClienteController {
    @Autowired
    IClienteService iClienteService;

    @GetMapping("consultar/cliente/{id}")
    private ResponseEntity<Cliente> buscar(@PathVariable Long id){
        Optional<Cliente> clienteOptional = iClienteService.buscarCliente(id);

        if (clienteOptional.isPresent()){
            return new ResponseEntity<Cliente>(clienteOptional.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @GetMapping("lista/cliente")
    private ResponseEntity<List<Cliente>> lista(){
        return new ResponseEntity<>(iClienteService.listaClientes(),HttpStatus.OK);
    }

    @GetMapping("consultar/cliente/{id}/suscripcion")
    private ResponseEntity<Collection<Suscripcion>> consultaClienteSuscripcion(@PathVariable Long id){
        return new ResponseEntity<>(iClienteService.buscarSuscripcionCliente(id),HttpStatus.OK);
    }

    @PostMapping("guardar/cliente")
    private ResponseEntity<Cliente> agregar(@RequestBody Cliente cliente)
    {
        return new ResponseEntity<Cliente>(iClienteService.agregarCliente(cliente),HttpStatus.CREATED);
    }

    @PutMapping("editar/cliente")
    private ResponseEntity<Cliente> editar(@RequestBody Cliente cliente){
        Optional<Cliente> clienteEncontrado= iClienteService.buscarCliente(cliente.getId());
        if (clienteEncontrado.isPresent()){
            cliente.setSuscripciones(clienteEncontrado.get().getSuscripciones());
           return new ResponseEntity<Cliente>(iClienteService.editarCliente(cliente),HttpStatus.OK) ;
        }
        return  new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("eliminar/cliente/{id}")
    private ResponseEntity<Void> eliminar(@PathVariable Long id){
        Cliente clienteEncontrado= iClienteService.buscarCliente(id).orElseThrow();
        if (clienteEncontrado != null){
            iClienteService.eliminarCliente(id);
            return new ResponseEntity<>(HttpStatus.OK) ;
        }
        return  new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
    }
}