package com.cancha.cliente.business;


import com.cancha.cliente.dto.EstablecimientoDto;
import com.cancha.cliente.repository.domain.Establecimiento;
import org.springframework.data.geo.Point;

import java.math.BigDecimal;
import java.util.List;

public interface EstablecimientoBusiness {

    /**
     *
     * @param point
     * @return
     */
    List<EstablecimientoDto> buscarEstablecimientoPorCoordenada(
            Point point
    );

    void saveEstablecimiento(Establecimiento establecimiento);
}
