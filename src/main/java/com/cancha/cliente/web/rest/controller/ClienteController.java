package com.cancha.cliente.web.rest.controller;

import com.cancha.cliente.dto.UsuarioDto;
import com.cancha.cliente.web.handler.error.ApiError;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Api(description = "Operaciones Vehiculos", tags = "Vehiculos")
public interface ClienteController {

    @ApiOperation(value = "Consultar datos vehiculo", response = UsuarioDto.class, produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses( value = {
            @ApiResponse(code = 423, response = ApiError.class, message = "Consulta ya realizada a esta placa, se debe esperar un tiempo para poder realizar nuevamente la consulta.")
    })
    ResponseEntity<UsuarioDto> registrarUsuario(@ApiParam("Placa a la cual se le realizará la consulta")@RequestBody UsuarioDto usuarioDto);
}
