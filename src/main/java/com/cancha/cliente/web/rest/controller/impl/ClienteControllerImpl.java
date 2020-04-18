package com.cancha.cliente.web.rest.controller.impl;

import com.cancha.cliente.business.UsuarioBusiness;
import com.cancha.cliente.dto.UsuarioDto;
import com.cancha.cliente.web.rest.controller.ClienteController;
import com.cancha.cliente.web.rest.controller.model.IngresoRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/cliente")
@Validated
public class ClienteControllerImpl implements ClienteController {

    private UsuarioBusiness usuarioBusiness;

    public ClienteControllerImpl(UsuarioBusiness usuarioBusiness) {
        this.usuarioBusiness = usuarioBusiness;
    }

    @PostMapping("/registro")
    @Override
    public ResponseEntity<UsuarioDto> registrarUsuario(@RequestBody UsuarioDto usuarioDto) {
        return ResponseEntity.ok(usuarioBusiness.registrarUsuario(usuarioDto));
    }

    @PostMapping
    @Override
    public ResponseEntity<UsuarioDto> validarIngreso(@RequestBody IngresoRequest ingresoRq) {
        return ResponseEntity.ok(usuarioBusiness.validarIngreso(ingresoRq.getNickName(),ingresoRq.getPassword()));
    }
}
