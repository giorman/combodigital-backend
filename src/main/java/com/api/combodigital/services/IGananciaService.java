package com.api.combodigital.services;

import com.api.combodigital.entities.Ganancia;

import java.util.Collection;
import java.util.Optional;

public interface IGananciaService {

    Collection<Ganancia> listaGanancia();
    Optional<Ganancia> buscarGanancia(long id);
    Ganancia agregarGanancia(Ganancia ganancia);
    Ganancia editarGanancia(Ganancia ganancia);
    Collection<Ganancia> editarValorGanancia(Double valor);
    void eliminarGanancia(Long id);
}
