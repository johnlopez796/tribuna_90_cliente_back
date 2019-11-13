package com.cancha.cliente.service;


import com.cancha.cliente.repository.domain.Establecimiento;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface EstablecimientoService {

    /**
     *
     * @param latMin
     * @param latMax
     * @param longMin
     * @param longMax
     * @return
     */
    @Deprecated
    List<Establecimiento> findByPosicion(BigDecimal latMin, BigDecimal latMax, BigDecimal longMin,
                                          BigDecimal longMax);

    /**
     *
     * @param idEstablecimiento
     * @return
     */
    Optional<Establecimiento> findById(String idEstablecimiento);

    /**
     *
     * @param point
     * @param distance
     * @return
     */
    List<Establecimiento> findByPosicion(Point point, Distance distance);

    void saveEstablecimiento(Establecimiento establecimiento);
}
