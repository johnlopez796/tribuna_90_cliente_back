package com.cancha.cliente.repository.domain;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Getter
@Setter
public class Establecimiento {
    @Id
    private String id;
    private String nombre;
    private String ubicacion;
    private Date endTime;
    @DBRef
    private Persona createUserId;
    private Date createDate;
    private Persona lastModId;
    @DBRef
    private Date lasModUser;
    private BigDecimal latitud;
    private BigDecimal longitud;
    private String horaApertura;
    private String horaCierre;
    private int numeroCanchas;
}
