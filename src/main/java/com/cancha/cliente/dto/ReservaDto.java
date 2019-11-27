package com.cancha.cliente.dto;


import com.cancha.cliente.repository.domain.Cancha;
import lombok.Data;

import java.util.Date;

@Data
public class ReservaDto {
    private String idReserva;
    private Date fechaReserva;
    private UsuarioDto usuarioDto;
    private CanchaDto cancha;
}
