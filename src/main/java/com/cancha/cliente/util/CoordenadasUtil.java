package com.cancha.cliente.util;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CoordenadasUtil {

    public BigDecimal coordMax(BigDecimal coord, BigDecimal distKm){
        coord = coord.add(distKm);
        return coord;
    }

    public BigDecimal coordMin(BigDecimal coord, BigDecimal distKm){
        coord = coord.subtract(distKm);
        return coord;
    }
}
