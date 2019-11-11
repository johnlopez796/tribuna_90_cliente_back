package com.cancha.cliente.business.impl;

import com.cancha.cliente.business.EstablecimientoBusiness;
import com.cancha.cliente.dto.CanchaDto;
import com.cancha.cliente.dto.EstablecimientoDto;
import com.cancha.cliente.map.CanchaMapper;
import com.cancha.cliente.map.EstablecimientoMapper;
import com.cancha.cliente.repository.domain.Cancha;
import com.cancha.cliente.service.CanchaService;
import com.cancha.cliente.service.EstablecimientoService;
import com.cancha.cliente.util.CoordenadasUtil;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstablecimientoBusinessImpl implements EstablecimientoBusiness {

    private EstablecimientoService establecimientoService;
    private EstablecimientoMapper establecimientoMapper;
    private CoordenadasUtil coordenadasUtil;
    private CanchaService canchaService;
    private CanchaMapper canchaMapper;

    public EstablecimientoBusinessImpl(EstablecimientoService establecimientoService, EstablecimientoMapper establecimientoMapper, CoordenadasUtil coordenadasUtil, CanchaService canchaService) {
        this.establecimientoService = establecimientoService;
        this.establecimientoMapper = establecimientoMapper;
        this.coordenadasUtil = coordenadasUtil;
        this.canchaService = canchaService;
    }

    public List<EstablecimientoDto> buscarEstablecimientoPorCoordenada(
            BigDecimal longitud, BigDecimal latitud
    ) {
        BigDecimal longMax = coordenadasUtil.coordMax(longitud, BigDecimal.valueOf(10));
        BigDecimal latMax = coordenadasUtil.coordMax(longitud, BigDecimal.valueOf(10));
        BigDecimal longMin = coordenadasUtil.coordMin(longitud, BigDecimal.valueOf(10));
        BigDecimal latMin = coordenadasUtil.coordMin(longitud, BigDecimal.valueOf(10));

        List<EstablecimientoDto> establecimientoList =
                establecimientoMapper.toEstablecimientoDtoList(establecimientoService.findByPosicion(latMin, latMax, longMin, longMax));

        for (int i = 0; i < establecimientoList.size(); i++) {
            List<CanchaDto> canchas = canchaMapper.toCanchaDtoList(canchaService.findByEstablecimiento(establecimientoList.get(i).getId()));
            establecimientoList.get(i).setCanchas(canchas);
            establecimientoList.get(i).setNumeroCanchas(canchas.size());
        }

        return establecimientoList;
    }
}
