package com.cancha.cliente.business.impl;

import com.cancha.cliente.business.EstablecimientoBusiness;
import com.cancha.cliente.business.ReservaBusiness;
import com.cancha.cliente.dto.*;
import com.cancha.cliente.map.ReservaMapper;
import com.cancha.cliente.repository.domain.Establecimiento;
import com.cancha.cliente.repository.domain.Reserva;
import com.cancha.cliente.repository.domain.Usuario;
import com.cancha.cliente.security.SecurityContext;
import com.cancha.cliente.service.ReservaService;
import com.cancha.cliente.web.handler.error.RestException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReservaBusinessImpl implements ReservaBusiness {

    private ReservaService reservaService;
    private ReservaMapper reservaMapper;
    private EstablecimientoBusiness establecimientoBusiness;
    private SecurityContext securityContext;

    public ReservaBusinessImpl(ReservaService reservaService, ReservaMapper reservaMapper, EstablecimientoBusiness establecimientoBusiness, SecurityContext securityContext) {
        this.reservaService = reservaService;
        this.reservaMapper = reservaMapper;
        this.establecimientoBusiness = establecimientoBusiness;
        this.securityContext = securityContext;
    }

    public List<ReservaBasicDto> reservaUsuario(String nickName, Date fechaIni, Date fechaFin) {
        UsuarioDto usuarioDto = securityContext.userSession();
        return reservaMapper.toListReservaBasicDto(
                reservaService.reservaUsuarioFecha(new Usuario(usuarioDto.getId()), fechaIni, fechaFin));
    }

    public List<HorarioDisponibleDto> generarDisponibilidad(Date fechaIni, Date fechaFin, String idEstablecimiento) {

        EstablecimientoDto establecimientoDto = establecimientoBusiness.buscarEstablecimiento(idEstablecimiento);

        List<Reserva> reservaList =
                reservaService.reservaPorFechaEstablecimiento(fechaIni, fechaFin, new Establecimiento(
                        establecimientoDto.getId()
                ));

        List<CanchaDto> canchaDtos = establecimientoDto.getCanchas();

        List<HorarioDisponibleDto> horarioDisponibleDtos = new ArrayList<>();

        canchaDtos.forEach(cancha -> {
            horarioDisponibleDtos.addAll(this.generarHorarioCancha(cancha,
                    establecimientoDto, reservaList, fechaIni, fechaFin));
        });

        if(horarioDisponibleDtos.isEmpty()){
            throw new RestException(HttpStatus.NOT_FOUND,"No hay reservas en el horario escogido");
        }

        return horarioDisponibleDtos;

    }

    public List<HorarioDisponibleDto> generarHorarioCancha(CanchaDto canchaDto, EstablecimientoDto establecimientoDto,
                                                           List<Reserva> reserva, Date fechaIni, Date fechaFin) {
        int horaMin = Integer.parseInt(establecimientoDto.getHoraApertura());
        int horaMax = Integer.parseInt(establecimientoDto.getHoraCierre());
        horaMax = horaMin >= horaMax?horaMin+1:horaMax;
        List<HorarioDisponibleDto> listHorario = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaFin);
        calendar.set(Calendar.HOUR_OF_DAY,horaMax);
        fechaFin = calendar.getTime();
        do {
            calendar = Calendar.getInstance();
            calendar.setTime(fechaIni);
            int hora = horaMin;
            for (; hora < horaMax; hora++) {

                HorarioDisponibleDto horarioDisponibleDto = new HorarioDisponibleDto();
                horarioDisponibleDto.setCanchaDto(canchaDto);
                calendar.set(Calendar.HOUR_OF_DAY, hora);
                horarioDisponibleDto.setHoraIni(calendar.getTime());
                calendar.add(Calendar.HOUR_OF_DAY, 1);
                horarioDisponibleDto.setHoraFin(calendar.getTime());
                horarioDisponibleDto.setTarifa(canchaDto.getTarifa());

                Optional<Reserva> reservaOpt = reserva.stream()
                        .filter(
                                reserva1 -> reserva1.getFechaReserva().compareTo(horarioDisponibleDto.getHoraIni()) == 0
                        ).findFirst();

                System.out.println(horarioDisponibleDto);

                if(!reservaOpt.isPresent())
                    listHorario.add(horarioDisponibleDto);
            }

            calendar.add(Calendar.DAY_OF_MONTH,1);
            fechaIni = calendar.getTime();

        } while (fechaIni.compareTo(fechaFin) < 0);

        return listHorario;
    }

    public String crearReserva(String idCancha, Date fechaReserva){
        ReservaDto reservaDto = new ReservaDto();
        reservaDto.setCancha(new CanchaDto());
        reservaDto.getCancha().setId(idCancha);
        reservaDto.setFechaReserva(fechaReserva);
        reservaDto.setUsuarioDto(this.securityContext.userSession());
        return reservaService.guardar(reservaMapper.toReserva(reservaDto)).getIdReserva();
    }
}
