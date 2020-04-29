package com.cancha.cliente.dto;


import com.cancha.cliente.repository.domain.Cancha;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.geo.Point;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class EstablecimientoDto<E> {
    private String id;
    private String nombre;
    private String ubicacion;
    private String horaApertura;
    private String horaCierre;
    private Point location;
    private int numeroCanchas;
    private List<CanchaDto> canchas;

    public void setNumeroCanchas(int numeroCanchas) {
        this.numeroCanchas = numeroCanchas;
    }

    public void setCanchas(List<CanchaDto> canchas) {
        this.canchas = canchas;
    }

    public String getId() {
        return id;
    }
}
