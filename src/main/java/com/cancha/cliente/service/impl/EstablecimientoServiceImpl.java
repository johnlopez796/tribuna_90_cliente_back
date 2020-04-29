package com.cancha.cliente.service.impl;

import com.cancha.cliente.repository.EstablecimientoRepository;
import com.cancha.cliente.repository.domain.Establecimiento;
import com.cancha.cliente.service.EstablecimientoService;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class EstablecimientoServiceImpl implements EstablecimientoService{

    private EstablecimientoRepository establecimientoRepository;

    public EstablecimientoServiceImpl(EstablecimientoRepository establecimientoRepository) {
        this.establecimientoRepository = establecimientoRepository;
    }

    @Deprecated
    @Override
    public List<Establecimiento> findByPosicion(BigDecimal latMin, BigDecimal latMax, BigDecimal longMin,
                                                BigDecimal longMax){
        return establecimientoRepository.findByLongAndLat(longMin,longMax,latMin,latMax);
    }

    @Override
    public Optional<Establecimiento> findById(String idEstablecimiento){
        return establecimientoRepository.findById(idEstablecimiento);
    }

    @Override
    public List<Establecimiento> findByPosicionNear(Point point, Distance distance){
        return establecimientoRepository.findBylocationNear(point,distance);
    }

    @Override
    public List<Establecimiento> findBylocation(Point point) {
        return establecimientoRepository.findBylocation(point);
    }

    @Override
    public Establecimiento findBynombre(String nombre) {
        return establecimientoRepository.findBynombre(nombre);
    }


    public void saveEstablecimiento(Establecimiento establecimiento){
        establecimientoRepository.save(establecimiento);
    }
}
