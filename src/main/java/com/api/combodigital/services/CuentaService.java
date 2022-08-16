package com.api.combodigital.services;

import com.api.combodigital.entities.Cuenta;
import com.api.combodigital.repositories.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class CuentaService implements ICuentaService {
    @Autowired
    CuentaRepository cuentaRepository;

    @Override
    public Collection<Cuenta> listaCuenta() {
        return cuentaRepository.findAll();
    }

    @Override
    public Optional<Cuenta> consultarCuenta(Long id) {
        return cuentaRepository.findById(id);
    }

    @Override
    public Cuenta agregarCuenta(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    @Override
    public Cuenta editarCuenta(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    @Override
    public void eliminar(Long id) {

        cuentaRepository.deleteById(id);
    }
}
