package com.cancha.cliente.dto;


import com.cancha.cliente.repository.domain.Cancha;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.geo.Point;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class EstablecimientoDto {
    private String id;
    private String nombre;
    private String ubicacion;
    private String horaApertura;
    private String horaCierre;
    private Point location;
    private int numeroCanchas;
    private List<CanchaDto> canchas;
}
