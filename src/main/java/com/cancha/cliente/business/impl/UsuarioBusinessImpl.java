package com.cancha.cliente.business.impl;

import com.cancha.cliente.business.UsuarioBusiness;
import com.cancha.cliente.dto.UsuarioDto;
import com.cancha.cliente.map.UsuarioMapper;
import com.cancha.cliente.repository.domain.Usuario;
import com.cancha.cliente.service.UsuarioService;
import com.cancha.cliente.validation.UsuarioValidation;
import com.cancha.cliente.web.handler.error.RestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

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
    public UsuarioDto registrarUsuario(UsuarioDto usuarioDto)throws RestException {
        Usuario usuario = usuarioMapper.toUsuarioDto(usuarioDto);
        usuarioValidation.validacionInicioSesion(usuario);
        usuario.setBloqueado(false);
        usuario.setFechaCreacion(new Date());
        usuario.setIntentos(0);
        usuario = usuarioService.saveUsuario(usuario);
        return usuarioMapper.toUsuario(usuario);
    }

    public UsuarioDto validarIngreso(String nickname, String password)throws RestException{
        Optional<Usuario> usuario = usuarioService.findByNickName(nickname);
        if(usuario.isPresent()){
            if(usuario.get().getPassword().equals(password)){
                usuarioValidation.validacionInicioSesion(usuario.get());
                usuario.get().setIntentos(0);
                usuario.get().setUltimoIngreso(new Date());
                usuarioService.saveUsuario(usuario.get());
                return usuarioMapper.toUsuario(usuario.get());
            }else {
                usuario.get().setIntentos(usuario.get().getIntentos()+1);
                usuarioService.saveUsuario(usuario.get());
                throw new RestException(HttpStatus.UNAUTHORIZED,"Usuario y/o contraseña invalidos");
            }
        }else{
            throw new RestException(HttpStatus.UNAUTHORIZED,"Usuario y/o contraseña invalidos");
        }
    }
}
