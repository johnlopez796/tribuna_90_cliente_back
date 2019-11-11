package com.cancha.cliente.web.rest.controller.impl;

import com.cancha.cliente.business.EstablecimientoBusiness;
import com.cancha.cliente.dto.EstablecimientoDto;
import com.cancha.cliente.dto.UsuarioDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/establecimiento")
public class EstablecimientoControllerImpl {

    private EstablecimientoBusiness establecimientoBusiness;

    public EstablecimientoControllerImpl(EstablecimientoBusiness establecimientoBusiness) {
        this.establecimientoBusiness = establecimientoBusiness;
    }

    @GetMapping("/{long}/{lat}")
    public ResponseEntity<List<EstablecimientoDto>> buscarEstablecimiento(
            @PathVariable("long")BigDecimal longitud,
            @PathVariable("long")BigDecimal latitud
    ){
        return ResponseEntity.ok(establecimientoBusiness.buscarEstablecimientoPorCoordenada(
                longitud,latitud
        ));
    }
}
