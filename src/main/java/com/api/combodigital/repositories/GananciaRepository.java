package com.api.combodigital.repositories;

import com.api.combodigital.entities.Ganancia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GananciaRepository extends JpaRepository<Ganancia,Long> {

}
