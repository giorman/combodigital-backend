package com.api.combodigital.services;

import com.api.combodigital.entities.Cuenta;
import com.api.combodigital.repositories.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

@Service
public class CuentaService implements ICuentaService {
    @Autowired
    CuentaRepository cuentaRepository;

    @Override
    @Transactional
    public Collection<Cuenta> listaCuenta() {
        return cuentaRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<Cuenta> consultarCuenta(Long id) {
        return cuentaRepository.findById(id);
    }

    @Override
    @Transactional
    public Cuenta agregarCuenta(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    @Override
    @Transactional
    public Cuenta editarCuenta(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {

        cuentaRepository.deleteById(id);
    }
}
