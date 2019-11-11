package com.cancha.cliente.repository;


import com.cancha.cliente.repository.domain.Cancha;
import com.cancha.cliente.repository.domain.Establecimiento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CanchaRepository extends CrudRepository<Cancha,String>{

    List<Cancha> findByEstablecimiento(Establecimiento establecimiento);


}
