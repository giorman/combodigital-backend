package com.api.combodigital.test.services.cuenta;


import com.api.combodigital.entities.Cuenta;

public class CuentaDataTest {

    private Long id;

    private String nombre;

    private Double precio;

    private Integer dia;


    public CuentaDataTest cuentaPorDefecto() {

        this.id = 1L;
        this.nombre = "Disney";
        this.precio = 7000.0;
        this.dia = 30;
        return this;
    }

    public Cuenta crear() {
        return new Cuenta(id,nombre,precio,dia,null);
    }

    public CuentaDataTest ConId(Long id) {
        this.id = id;
        return this;
    }

    public CuentaDataTest ConNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public CuentaDataTest conPrecio(Double precio) {
        this.precio = precio;
        return this;
    }

    public CuentaDataTest conDia(String dia) {
        this.precio = precio;
        return this;
    }


}
