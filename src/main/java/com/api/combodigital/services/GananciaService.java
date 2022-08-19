package com.api.combodigital.services;

import com.api.combodigital.entities.Ganancia;
import com.api.combodigital.repositories.GananciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

@Service
public class GananciaService implements IGananciaService{

    @Autowired
    private GananciaRepository gananciaRepository;

    @Override
    @Transactional
    public Collection<Ganancia> listaGanancia() {
        return gananciaRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<Ganancia> buscarGanancia(long id) {
        return gananciaRepository.findById(id);
    }

    @Override
    @Transactional
    public Ganancia agregarGanancia(Ganancia ganancia) {
        return gananciaRepository.save(ganancia);
    }

    @Override
    @Transactional
    public Ganancia editarGanancia(Ganancia ganancia) {
        return gananciaRepository.save(ganancia);
    }

    @Override
    @Transactional
    public Collection<Ganancia> editarValorGanancia(Double valor) {
        gananciaRepository.findAll().forEach((ganancia -> {
            if (ganancia.getId()== LocalDate.now().getMonthValue()){
                ganancia.setValor(ganancia.getValor()+valor);
                gananciaRepository.save(ganancia);
            }
        }));
        return gananciaRepository.findAll();
    }

    @Override
    @Transactional
    public void eliminarGanancia(Long id) {
            gananciaRepository.deleteById(id);
    }
}
