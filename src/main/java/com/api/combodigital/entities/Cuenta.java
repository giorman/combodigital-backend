package com.api.combodigital.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "cuentas")
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String nombre;

    @Getter
    @Setter
    private Double precio;

    @Getter
    @Setter
    private Integer dia;

    @OneToMany(mappedBy = "cuenta")
    @JsonBackReference
    @Getter
    @Setter
    private Set<Suscripcion> suscripcion = new HashSet<>();


}
