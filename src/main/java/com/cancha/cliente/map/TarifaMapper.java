package com.cancha.cliente.map;

import com.cancha.cliente.config.MapStructConfig;
import com.cancha.cliente.dto.TarifaDto;
import com.cancha.cliente.repository.domain.Tarifa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", config = MapStructConfig.class)
public abstract class TarifaMapper {

    public abstract TarifaDto tarifaDto(Tarifa tarifa);

}
