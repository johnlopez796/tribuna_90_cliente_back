package com.cancha.cliente.business;

import com.cancha.cliente.dto.CanchaDto;
import com.cancha.cliente.dto.EstablecimientoDto;
import com.cancha.cliente.dto.HorarioDisponibleDto;
import com.cancha.cliente.dto.ReservaBasicDto;
import com.cancha.cliente.repository.domain.Reserva;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


public interface ReservaBusiness {

    List<ReservaBasicDto> reservaUsuario(String nickName, Date fechaIni, Date fechaFin);

    List<HorarioDisponibleDto> generarDisponibilidad(Date fechaIni, Date fechaFin, String idEstablecimiento);

    List<HorarioDisponibleDto> generarHorarioCancha(CanchaDto canchaDto, EstablecimientoDto establecimientoDto,
                                                    List<Reserva> reserva, Date fechaIni, Date fechaFin);
}
