package com.cancha.cliente.web.rest.controller.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
public class ReservaRequestDto {
    private String idCancha;
    @JsonFormat(pattern = "yyyy-MM-dd-HH")
    private Date fechaReserva;
}
