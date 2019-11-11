package com.cancha.cliente.business;


import com.cancha.cliente.dto.EstablecimientoDto;

import java.math.BigDecimal;
import java.util.List;

public interface EstablecimientoBusiness {

    /**
     *
     * @param longitud
     * @param latitud
     * @return
     */
    List<EstablecimientoDto> buscarEstablecimientoPorCoordenada(
            BigDecimal longitud, BigDecimal latitud
    );
}
