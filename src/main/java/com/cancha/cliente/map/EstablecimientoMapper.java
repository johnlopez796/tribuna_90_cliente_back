package com.cancha.cliente.map;

import com.cancha.cliente.config.MapStructConfig;
import com.cancha.cliente.dto.EstablecimientoDto;
import com.cancha.cliente.repository.domain.Establecimiento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", config = MapStructConfig.class, uses = CanchaMapper.class)
public abstract class EstablecimientoMapper {


    public abstract EstablecimientoDto toEstablecimientoDto(Establecimiento establecimiento);

    public abstract List<EstablecimientoDto> toEstablecimientoDtoList(List<Establecimiento> establecimiento);
}
