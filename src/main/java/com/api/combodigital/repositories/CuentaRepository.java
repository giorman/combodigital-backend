package com.api.combodigital.repositories;

import com.api.combodigital.entities.Cuenta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CuentaRepository extends CrudRepository<Cuenta,Long> {

    Collection<Cuenta> findAll();

}
