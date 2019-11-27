package com.cancha.cliente.service;


import com.cancha.cliente.repository.domain.Establecimiento;
import com.cancha.cliente.repository.domain.Reserva;
import com.cancha.cliente.repository.domain.Usuario;

import java.util.Date;
import java.util.List;

public interface ReservaService {

    List<Reserva> reservaUsuarioFecha(Usuario usuario, Date fechaInicial, Date fechaFinal);

    List<Reserva> reservaPorFecha(Date fechaInicial, Date fechaFinal);

    List<Reserva> reservaPorFechaEstablecimiento(Date fechaInicial, Date fechaFinal, Establecimiento establecimiento);
}
