package com.cancha.cliente.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TarifaDto {
    private String id;
    private BigDecimal tarifa;
}
