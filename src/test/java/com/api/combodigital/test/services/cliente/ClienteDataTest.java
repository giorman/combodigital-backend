package com.api.combodigital.test.services.cliente;

import com.api.combodigital.entities.Cliente;

public class ClienteDataTest {

    private Long id;

    private String nombre;

    private String apellido;

    private String telefono;


    public ClienteDataTest clientePorDefecto() {

        this.id= 1L;
        this.nombre = "Fernando";
        this.apellido = "Castillo";
        this.telefono = "3152485896";

        return this;
    }

    public Cliente crear() {

        return new Cliente(id,nombre,apellido,telefono,null);
    }

    public ClienteDataTest ConId(Long id) {
        this.id = id;
        return this;
    }

    public ClienteDataTest ConNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ClienteDataTest conTelefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

}
