package com.cancha.cliente.web.rest.controller.impl;

import com.cancha.cliente.business.EstablecimientoBusiness;
import com.cancha.cliente.dto.EstablecimientoDto;
import com.cancha.cliente.dto.UsuarioDto;
import com.cancha.cliente.repository.domain.Establecimiento;
import org.springframework.data.geo.Point;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            @PathVariable("lat")BigDecimal latitud
    ){
        return ResponseEntity.ok(establecimientoBusiness.buscarEstablecimientoPorCoordenada(
              new Point(latitud.doubleValue(),longitud.doubleValue())
        ));
    }

    @PostMapping
    public void guardarEstablecimiento(@RequestBody Establecimiento establecimiento){
        this.establecimientoBusiness.saveEstablecimiento(establecimiento);
    }
}
