package com.cancha.cliente.validation.impl;

import com.cancha.cliente.repository.domain.Persona;
import com.cancha.cliente.repository.domain.Usuario;
import com.cancha.cliente.service.UsuarioService;
import com.cancha.cliente.validation.UsuarioValidation;
import com.cancha.cliente.web.handler.error.RestException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UsuarioValidationImpl implements UsuarioValidation {

    private UsuarioService usuarioService;

    public UsuarioValidationImpl(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    /**
     * @param usuario
     */
    public void validacionInicioSesion(Usuario usuario) throws RestException{

    }

    /**
     * @param usuario
     */
    public void validacionRegistro(Usuario usuario) throws RestException {
        Optional<Usuario> usrBD = this.usuarioService.findByNickName(usuario.getNickname());

        if(usrBD.isPresent()){
            throw new RestException(HttpStatus.CONFLICT, "Ya existe nickname");
        }else{
            Persona persona = usuario.getPersona();
            usrBD = this.usuarioService.findByDocyType(persona.getDocumento(),persona.getTipoDocumento());
            usrBD.ifPresent(
                    usuario1 -> {
                        throw new RestException(HttpStatus.CONFLICT, "El usuario ya se encuentra registrado.");
                    }
            );
        }

    }

}
