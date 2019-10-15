package com.cancha.cliente.web.rest.controller;

import com.cancha.cliente.dto.UsuarioDto;
import com.cancha.cliente.web.handler.error.ApiError;
import com.cancha.cliente.web.rest.controller.model.IngresoRequest;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Api(description = "Operaciones Vehiculos", tags = "Vehiculos")
public interface ClienteController {

    @ApiOperation(value = "Registro de cliente", response = UsuarioDto.class, produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses( value = {
            @ApiResponse(code = 409, response = ApiError.class, message = "Usuario o nickname ya existe")
    })
    ResponseEntity<UsuarioDto> registrarUsuario(@RequestBody UsuarioDto usuarioDto);

    @ApiOperation(value = "Validar ingreso a la aplicación", response = UsuarioDto.class, produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses( value = {
            @ApiResponse(code = 409, response = ApiError.class, message = "Usuario bloqueado"),
            @ApiResponse(code = 401, response = ApiError.class, message = "Contraseña y/o usuario invalido")
    })
    ResponseEntity<UsuarioDto> validarIngreso(@Valid @RequestBody IngresoRequest ingresoRq);
}
