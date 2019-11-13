package com.cancha.cliente.util;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CoordenadasUtil {

    public BigDecimal coordMax(BigDecimal coord, BigDecimal distKm){
        distKm = coord.setScale(6,BigDecimal.ROUND_HALF_UP);
        coord = coord.add(distKm);
        coord = coord.setScale(6,BigDecimal.ROUND_HALF_UP);
        return coord;
    }

    public BigDecimal coordMin(BigDecimal coord, BigDecimal distKm){
        coord = coord.subtract(distKm);
        return coord;
    }
}
