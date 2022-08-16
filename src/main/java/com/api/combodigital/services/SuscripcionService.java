package com.api.combodigital.services;

import com.api.combodigital.entities.Suscripcion;
import com.api.combodigital.repositories.SuscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SuscripcionService implements ISuscripcionService {
    @Autowired
    private SuscripcionRepository suscripcionRepository;

    @Override
    public Collection<Suscripcion> listaSuscripcion() {
        return suscripcionRepository.findAll();
    }

    @Override
    public Collection<Suscripcion> listaSuscripcionRenovaciones() {
        Collection<Suscripcion> renovaciones = new ArrayList<>();
        //guardar todas las suscripciones que se deben renovar 6 dia antes
        for (int i = 1; i <= 6; i++) {
            Period period = Period.ofDays(-i);
            renovaciones = suscripcionRepository.findAll().stream()
                    .filter((suscripcion) -> (LocalDate.now().isAfter(suscripcion.getFechaFinal().plus(period))
                            || LocalDate.now().equals(suscripcion.getFechaFinal())) && suscripcion.getEstado())
                    .collect(Collectors.toList());
        }
        //pone la suscripciones que ya se vencieron en inactivas
        renovaciones.forEach((suscripcion) -> {
            if (suscripcion.getFechaFinal().isBefore(LocalDate.now())) {
                suscripcion.setEstado(false);
                editarSuscripcion(suscripcion);
            }
        });
        return renovaciones;
    }

    @Override
    public Collection<Suscripcion> listaSuscripcionVencidas() {
        Collection<Suscripcion> vencidas = suscripcionRepository.findAll().stream()
                .filter(resultado->resultado.getEstado()==false).collect(Collectors.toList());
        return vencidas;
    }

    @Override
    public Optional<Suscripcion> consultarSuscripcion(Long id) {
        return suscripcionRepository.findById(id);
    }

    @Override
    public Suscripcion agregarSuscripcion(Suscripcion suscripicion) {
        return suscripcionRepository.save(suscripicion);
    }

    @Override
    public Suscripcion editarSuscripcion(Suscripcion suscripcion) {
        return suscripcionRepository.save(suscripcion);
    }

    @Override
    public void eliminarSuscripcion(Long id) {
        suscripcionRepository.deleteById(id);
    }
}
