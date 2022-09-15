package com.api.combodigital.test.controllers.controlador;




public class ClienteDataTest {



    private String nombre;

    private String apellido;

    private String telefono;


    public ClienteDataTest clientePorDefecto() {

        this.nombre = "Giorman2";
        this.apellido = "Rodriguez";
        this.telefono = "3152485896";

        return this;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
