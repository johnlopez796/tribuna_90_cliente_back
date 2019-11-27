package com.cancha.cliente.service.impl;

import com.cancha.cliente.repository.ReservaRepository;
import com.cancha.cliente.repository.domain.Establecimiento;
import com.cancha.cliente.repository.domain.Reserva;
import com.cancha.cliente.repository.domain.Usuario;
import com.cancha.cliente.service.ReservaService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReservaServiceImpl implements ReservaService{

    private ReservaRepository reservaRepository;

    public ReservaServiceImpl(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    @Override
    public List<Reserva> reservaUsuarioFecha(Usuario usuario, Date fechaInicial, Date fechaFinal){
        return reservaRepository.reservaUsuarioFecha(usuario,fechaInicial,fechaFinal);
    }

    @Override
    public List<Reserva> reservaPorFecha(Date fechaInicial, Date fechaFinal){
        return reservaRepository.reservaPorFecha(fechaInicial,fechaFinal);
    }

    @Override
    public List<Reserva> reservaPorFechaEstablecimiento(Date fechaInicial, Date fechaFinal, Establecimiento establecimiento){
        return reservaRepository.reservaPorFechaEstablecimiento(fechaInicial,fechaFinal,establecimiento);
    }

    public Reserva guardar(Reserva reserva){
        return reservaRepository.save(reserva);
    }
}
