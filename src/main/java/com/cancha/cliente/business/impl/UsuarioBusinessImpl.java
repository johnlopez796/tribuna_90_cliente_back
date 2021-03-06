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

import java.util.*;

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
        Optional<Usuario> usuarioOld = usuarioService.findByNickName(usuarioDto.getNickname());

        if (!usuarioOld.isPresent()){

            Usuario usuario = usuarioMapper.toUsuarioDto(usuarioDto);
            usuarioValidation.validacionInicioSesion(usuario);
            usuario.setId(usuarioDto.getDocumento());
            usuario.setBloqueado(false);
            usuario.setFechaCreacion(new Date());
            usuario.setIntentos(0);
            usuario = usuarioService.saveUsuario(usuario);
            List<String> rol = new ArrayList<>();
            rol.add("cliente");
            UsuarioDto usuarioDtoR = usuarioMapper.toUsuario(usuario);
            usuarioDto.setRol(rol);
            return usuarioDtoR;
        } else {
            throw new RestException(HttpStatus.UNAUTHORIZED,"Usuario ya existe en plataforma");
        }

    }

    public UsuarioDto validarIngreso(String nickname, String password)throws RestException{
        Optional<Usuario> usuario = usuarioService.findByNickName(nickname);
        if(usuario.isPresent()){
            if(usuario.get().getPassword().equals(password)){
                usuarioValidation.validacionInicioSesion(usuario.get());
                usuario.get().setIntentos(0);
                usuario.get().setUltimoIngreso(new Date());
                usuarioService.saveUsuario(usuario.get());
                UsuarioDto usuarioDtoR = usuarioMapper.toUsuario(usuario.get());
                List<String> rol = new ArrayList<>();
                usuarioDtoR.setToken(String.valueOf(Math.random()*20));
                rol.add("cliente");
                usuarioDtoR.setRol(rol);
                return usuarioDtoR;
            }else {
                usuario.get().setIntentos(usuario.get().getIntentos()+1);
                usuarioService.saveUsuario(usuario.get());
                throw new RestException(HttpStatus.UNAUTHORIZED,"Usuario y/o contraseña invalidos");
            }
        }else{
            throw new RestException(HttpStatus.UNAUTHORIZED,"Usuario no registrado");
        }
    }
}
