package com.cancha.cliente.web.rest.controller.impl;

import com.cancha.cliente.business.ReservaBusiness;
import com.cancha.cliente.dto.HorarioDisponibleDto;
import com.cancha.cliente.web.rest.controller.ReservaController;
import com.cancha.cliente.web.rest.controller.model.ReservaId;
import com.cancha.cliente.web.rest.controller.model.ReservaRequestDto;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/reserva")
@Validated
public class ReservaControllerImpl implements ReservaController {

    private ReservaBusiness reservaBusiness;

    public ReservaControllerImpl(ReservaBusiness reservaBusiness) {
        this.reservaBusiness = reservaBusiness;
    }

    @GetMapping()//"/{idEstablecimiento}/{fechaIni}/{fechaFin}")
    public List<HorarioDisponibleDto> listaReservaEstablecimiento(
            @RequestParam("idEstablecimiento") String idEstablecimiento,
            @RequestParam("fechaIni") @DateTimeFormat(pattern = "yyyy-MM-dd-HH") Date fechaIni,
            @RequestParam("fechaFin") @DateTimeFormat(pattern = "yyyy-MM-dd-HH") Date fechaFin) {
        return reservaBusiness.generarDisponibilidad(fechaIni, fechaFin, idEstablecimiento);
    }

    @PostMapping
    public ReservaId generarReserva(@RequestBody ReservaRequestDto reservaRequestDto){
        return new ReservaId(reservaBusiness.crearReserva(reservaRequestDto.getIdCancha(),reservaRequestDto.getFechaReserva()));
    }
}
