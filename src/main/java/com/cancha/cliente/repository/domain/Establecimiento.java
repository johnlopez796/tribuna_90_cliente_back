package com.cancha.cliente.repository.domain;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.Date;

@Data
@Getter
@Setter
public class Establecimiento {
    @Id
    private Integer id;
    private String nombre;
    private String ubicacion;
    private Date endTime;
    @DBRef
    private Persona createUserId;
    private Date createDate;
    private Persona lastModId;
    @DBRef
    private Date lasModUser;
    private String latitud;
    private String longitud;
    private String horaApertura;
    private String horaCierre;
}
