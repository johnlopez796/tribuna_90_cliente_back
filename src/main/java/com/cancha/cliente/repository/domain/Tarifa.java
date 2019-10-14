package com.cancha.cliente.repository.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;

@Document
@Setter
@Getter
public class Tarifa {
    private String id;
    private String nombre;
    private BigDecimal tarifa;
    private Integer horaIni;
    private Integer horaFin;
    private Boolean estado;
    private Date fechaCreacion;
}
