package com.cancha.cliente.business.impl;

import com.cancha.cliente.business.EstablecimientoBusiness;
import com.cancha.cliente.dto.CanchaDto;
import com.cancha.cliente.dto.EstablecimientoDto;
import com.cancha.cliente.map.CanchaMapper;
import com.cancha.cliente.map.EstablecimientoMapper;
import com.cancha.cliente.repository.domain.Establecimiento;
import com.cancha.cliente.service.CanchaService;
import com.cancha.cliente.service.EstablecimientoService;
import com.cancha.cliente.util.CoordenadasUtil;
import com.cancha.cliente.web.handler.error.RestException;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstablecimientoBusinessImpl implements EstablecimientoBusiness {

    private EstablecimientoService establecimientoService;
    private EstablecimientoMapper establecimientoMapper;
    private CoordenadasUtil coordenadasUtil;
    private CanchaService canchaService;
    private CanchaMapper canchaMapper;

    public EstablecimientoBusinessImpl(EstablecimientoService establecimientoService, EstablecimientoMapper establecimientoMapper, CoordenadasUtil coordenadasUtil, CanchaService canchaService
    ,CanchaMapper canchaMapper) {
        this.establecimientoService = establecimientoService;
        this.establecimientoMapper = establecimientoMapper;
        this.coordenadasUtil = coordenadasUtil;
        this.canchaService = canchaService;
        this.canchaMapper = canchaMapper;
    }

    public List<EstablecimientoDto> buscarEstablecimientoPorCoordenada(
            Point point
    ) {

        Distance distance = new Distance(5, Metrics.KILOMETERS);

        List<EstablecimientoDto> establecimientoList =
                establecimientoMapper.toEstablecimientoDtoList(establecimientoService.findByPosicion(point, distance));

        for (int i = 0; i < establecimientoList.size(); i++) {
            List<CanchaDto> canchas = canchaMapper.toCanchaDtoList(canchaService.findByEstablecimiento(establecimientoList.get(i).getId()));
            establecimientoList.get(i).setCanchas(canchas);
            establecimientoList.get(i).setNumeroCanchas(canchas.size());
        }

        return establecimientoList;
    }

    public void saveEstablecimiento(Establecimiento establecimiento) {
        establecimientoService.saveEstablecimiento(establecimiento);
    }

    public EstablecimientoDto buscarEstablecimiento(String idEstablecimiento) {
        EstablecimientoDto establecimientoDto = establecimientoMapper.toEstablecimientoDto(establecimientoService
                .findById(idEstablecimiento)
                .orElseThrow(() -> new RestException(HttpStatus.NOT_FOUND, "No existe el establecimiento"))
        );

        List<CanchaDto> canchas = canchaMapper.toCanchaDtoList(canchaService.findByEstablecimiento(establecimientoDto.getId()));
        establecimientoDto.setCanchas(canchas);
        establecimientoDto.setNumeroCanchas(canchas.size());

        return establecimientoDto;
    }
}
