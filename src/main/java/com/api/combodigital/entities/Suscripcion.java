package com.api.combodigital.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "suscripciones")
public class Suscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String correo;

    @Getter
    @Setter
    private String password;

    @Getter
    @Setter
    private Boolean estado;

    @Getter
    @Setter
    private LocalDate fechaInicio;

    @Getter
    @Setter
    private LocalDate fechaFinal;

    @Getter
    @Setter
    private String perfil;

    @Getter
    @Setter
    private String pin;

    @Getter
    @Setter
    private Integer precio;

    @Getter
    @Setter
    private String proveedor;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    @Getter
    @Setter
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "cuenta_id")
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    @Getter
    @Setter
    private Cuenta cuenta;

    public Suscripcion() {
        super();
    }

}
