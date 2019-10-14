package com.cancha.cliente.repository.domain;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Getter
@Setter
public class Foto {
    @Id
    private String id;
    @DBRef
    private Cancha idCancha;
    private Binary foto;
    private Boolean estado;
    private Integer alto;
    private Integer ancho;
    private Date fechaCreacion;
}
