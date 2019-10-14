package com.cancha.cliente.repository.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Getter
@Setter
public class Descuento {
    @Id
    private String id;
    private Integer porcentajeDescuento;
    private boolean estado;
    private Date fechaCreacion;
    private Date fechaInicio;
    private Date fechaFin;
    @DBRef
    private Tarifa tarifa;
}
