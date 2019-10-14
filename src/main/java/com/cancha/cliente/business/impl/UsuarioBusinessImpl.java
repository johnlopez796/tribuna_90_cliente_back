package com.cancha.cliente.business.impl;

import com.cancha.cliente.business.UsuarioBusiness;
import com.cancha.cliente.dto.UsuarioDto;
import com.cancha.cliente.map.UsuarioMapper;
import com.cancha.cliente.repository.domain.Usuario;
import com.cancha.cliente.service.UsuarioService;
import com.cancha.cliente.validation.UsuarioValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 *
 */
@Service
public class UsuarioBusinessImpl implements UsuarioBusiness{
    private UsuarioService usuarioService;
    private UsuarioValidation usuarioValidation;
    private UsuarioMapper usuarioMapper;

    public UsuarioBusinessImpl(UsuarioService usuarioService, UsuarioValidation usuarioValidation, UsuarioMapper usuarioMapper) {
        this.usuarioService = usuarioService;
        this.usuarioValidation = usuarioValidation;
        this.usuarioMapper = usuarioMapper;
    }

    /**
     *
     * @param usuarioDto
     * @return
     */
    public UsuarioDto registrarUsuario(UsuarioDto usuarioDto){
        Usuario usuario = usuarioMapper.toUsuarioDto(usuarioDto);
        usuarioValidation.validacionInicioSesion(usuario);
        usuario.setBloqueado(false);
        usuario.setFechaCreacion(new Date());
        usuario.setIntentos(0);
        usuario = usuarioService.saveUsuario(usuario);
        return usuarioMapper.toUsuario(usuario);
    }
}
