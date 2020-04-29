package com.cancha.cliente.business;


import com.cancha.cliente.dto.EstablecimientoDto;
import com.cancha.cliente.repository.domain.Establecimiento;
import org.springframework.data.geo.Point;

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

    /**
     *
     * @param nombre
     * @return
     */
    EstablecimientoDto<EstablecimientoDto> buscarEstablecimientoPorNombre(String nombre );


    /**
     *
     * @param establecimiento
     */
    void saveEstablecimiento(Establecimiento establecimiento);

    /**
     *
     * @param idEstablecimiento
     * @return
     */
    EstablecimientoDto buscarEstablecimiento(String idEstablecimiento);

}
