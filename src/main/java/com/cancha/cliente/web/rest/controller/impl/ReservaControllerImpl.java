package com.cancha.cliente.web.rest.controller.impl;

import com.cancha.cliente.business.ReservaBusiness;
import com.cancha.cliente.dto.HorarioDisponibleDto;
import com.cancha.cliente.web.rest.controller.ReservaController;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
