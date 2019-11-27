package com.cancha.cliente.repository;

import com.cancha.cliente.repository.domain.Establecimiento;
import com.cancha.cliente.repository.domain.Reserva;
import com.cancha.cliente.repository.domain.Usuario;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservaRepository extends CrudRepository<Reserva, String> {

    @Query("{fechaReserva: {$lt:?1, $gt:?2},usuario: ?0}")
    List<Reserva> reservaUsuarioFecha(Usuario usuario, Date fechaInicial, Date fechaFinal);

    @Query("{fechaReserva: {$lt:?0, $gt:?1}}")
    List<Reserva> reservaPorFecha(Date fechaInicial, Date fechaFinal);

    @Query("{fechaReserva: {$lt:?0, $gt:?1}, cancha: {establecimiento: ?2}}")
    List<Reserva> reservaPorFechaEstablecimiento(Date fechaInicial, Date fechaFinal, Establecimiento establecimiento);
}
