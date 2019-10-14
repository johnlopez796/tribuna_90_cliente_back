package com.cancha.cliente.validation;


import com.cancha.cliente.repository.domain.Usuario;
import com.cancha.cliente.web.handler.error.RestException;

public interface UsuarioValidation {

    /**
     *
     * @param usuario
     * @throws RestException
     */
    void validacionInicioSesion(Usuario usuario) throws RestException;

    /**
     *
     * @param usuario
     * @throws RestException
     */
    void validacionRegistro(Usuario usuario) throws RestException;
}
