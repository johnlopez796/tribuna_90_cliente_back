package com.cancha.cliente.repository;

import com.cancha.cliente.repository.domain.Establecimiento;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface EstablecimientoRepository extends CrudRepository<Establecimiento,String>{

    @Query("{latitud: {$lt: ?0, $gt:?1},longitud: {$lt: ?2, $gt:?3}}")
    List<Establecimiento> findByLongAndLat(BigDecimal longitudMin,
                                           BigDecimal longitudMax,
                                           BigDecimal latitudMin,
                                           BigDecimal latitudMax);

    List<Establecimiento> findBylocationNear(Point point, Distance distance);
}
