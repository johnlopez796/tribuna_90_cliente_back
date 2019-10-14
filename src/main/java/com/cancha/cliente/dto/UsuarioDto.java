package com.cancha.cliente.dto;

import com.cancha.cliente.repository.domain.type.TipoDocumento;
import lombok.Data;

import java.util.Date;

@Data
public class UsuarioDto {
    private String id;
    private TipoDocumento tipoDocumento;
    private String documento;
    private String nombres;
    private String apellidos;
    private Date fechaNacimiento;
    private String nickname;
    private String email;
    private String clave;
}
