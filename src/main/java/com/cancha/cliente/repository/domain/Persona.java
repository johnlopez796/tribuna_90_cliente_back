package com.cancha.cliente.repository.domain;

import com.cancha.cliente.repository.domain.type.TipoDocumento;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.Date;

@Getter
@Setter
public class Persona {
    private String nombres;
    private String apellidos;
    private Date fechaNacimiento;
    private String genero;
    private String email;
    private String documento;
    private TipoDocumento tipoDocumento;
    private Date fechaRegistro;

}
