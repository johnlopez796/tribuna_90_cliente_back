package com.cancha.cliente.repository;

import com.cancha.cliente.repository.domain.Reserva;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends CrudRepository<Reserva,String>{
}
