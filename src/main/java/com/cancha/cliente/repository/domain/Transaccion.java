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
public class Transaccion {
    @Id
    private String id;
    private Date fechaRegistro;
    @DBRef
    private Reserva reserva;
    private String estado;
    private String idConfirmacion;
    private Date fechaAprobacion;
}
