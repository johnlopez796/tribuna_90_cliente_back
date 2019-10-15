package com.cancha.cliente.business;


import com.cancha.cliente.dto.UsuarioDto;
import com.cancha.cliente.web.handler.error.RestException;

public interface UsuarioBusiness {

    /**
     *
     * @param usuarioDto
     * @return
     */
    UsuarioDto registrarUsuario(UsuarioDto usuarioDto) throws RestException;

    /**
     *
     * @param nickname
     * @param password
     * @return
     * @throws RestException
     */
    UsuarioDto validarIngreso(String nickname, String password) throws RestException;

}
