package com.cancha.cliente.map;

import com.cancha.cliente.config.MapStructConfig;
import com.cancha.cliente.dto.EstablecimientoDto;
import com.cancha.cliente.repository.domain.Establecimiento;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring", config = MapStructConfig.class, uses = CanchaMapper.class)
public abstract class EstablecimientoMapper {


    public abstract EstablecimientoDto EstablecimientoDtotoEstablecimientoDto(Establecimiento establecimiento);

    public abstract List<EstablecimientoDto> toEstablecimientoDtoList(List<Establecimiento> establecimiento);


}
