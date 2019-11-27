package com.cancha.cliente.repository.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Document
@Getter
@Setter
public class Cancha {
    @Id
    @NotNull
    private String id;
    private Integer capacidad;
    private String tipoGrama;
    @DBRef
    private Establecimiento establecimiento;
    private String tipoTecho;
    private Date createDate;
    //@DBRef
    private Persona lastModUserId;
    private Date lastModDate;
   // @DBRef
    private Tarifa tarifa;
}
