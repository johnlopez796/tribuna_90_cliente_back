package com.cancha.cliente.dto;

import com.cancha.cliente.repository.domain.type.TipoDocumento;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

@Data
public class UsuarioDto {
    private String id;
    @NotEmpty
    private TipoDocumento tipoDocumento;
    @NotEmpty
    private String documento;
    @NotEmpty
    private String nombres;
    private String token;
    @NotEmpty
    private String apellidos;
    private Date fechaNacimiento;
    @NotEmpty
    private String nickname;
    @NotEmpty
    @Email
    private String email;
    private String clave;
    private List<String> rol;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getNickname() {
        return nickname;
    }

    public String getDocumento() {
        return documento;
    }

    public void setId(String id) {
        this.id = id;
    }
}
