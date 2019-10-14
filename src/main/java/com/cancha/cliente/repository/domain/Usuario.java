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
public class Usuario {
    @Id
    private String id;
    private String nickname;
    private String password;
    private int intentos;
    private boolean bloqueado;
    private Date fechaCreacion;
    private Date ultimoIngreso;
    private Persona persona;
}
