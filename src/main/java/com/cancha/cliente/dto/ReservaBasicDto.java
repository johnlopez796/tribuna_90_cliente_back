package com.cancha.cliente.dto;


import lombok.Data;

import java.util.Date;

@Data
public class ReservaBasicDto {
    private String idReserva;
    private Date fechaReserva;
    private CanchaDto cancha;
}
