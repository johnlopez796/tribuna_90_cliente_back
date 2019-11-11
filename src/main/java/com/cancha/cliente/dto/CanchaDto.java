package com.cancha.cliente.dto;


import com.cancha.cliente.repository.domain.Tarifa;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CanchaDto {
    private String id;
    private Integer capacidad;
    private String tipoGrama;
    private String tipoTecho;
    private Tarifa tarifa;
}
