package com.cancha.cliente.web.rest.controller;


import com.cancha.cliente.dto.EstablecimientoDto;
import com.cancha.cliente.dto.UsuarioDto;
import com.cancha.cliente.web.handler.error.ApiError;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface EstablecimientoController {

    @ApiOperation(value = "Registro de establecimiento", response = EstablecimientoDto.class, produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses( value = {
            @ApiResponse(code = 409, response = ApiError.class, message = "Establecimiento ya existe")
    })
    ResponseEntity<EstablecimientoDto> guardarEstablecimiento(@RequestBody EstablecimientoDto establecimientoDto);

    @ApiOperation(value = "Validar la consulta de establecimientos", response = EstablecimientoDto.class, produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses( value = {
            @ApiResponse(code = 409, response = ApiError.class, message = "Establecimiento no existe"),
            @ApiResponse(code = 401, response = ApiError.class, message = "No se encuentra establecimiento")
    })
    ResponseEntity<UsuarioDto> buscarEstablecimiento(@Valid @RequestBody String nombre);

}
