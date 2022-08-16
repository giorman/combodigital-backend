package com.api.combodigital.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String nombre;

    @Getter
    @Setter
    private String apellido;

    @Getter
    @Setter
    private String telefono;

    @OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL)
    @JsonBackReference
    @Getter
    @Setter
    private Set<Suscripcion> suscripciones = new HashSet<>();


    }

