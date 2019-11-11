package com.cancha.cliente.map;

import com.cancha.cliente.config.MapStructConfig;
import com.cancha.cliente.dto.CanchaDto;
import com.cancha.cliente.repository.domain.Cancha;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", config = MapStructConfig.class)
public abstract class CanchaMapper {

    public abstract CanchaDto toCanchaDto(Cancha cancha);

    public abstract List<CanchaDto> toCanchaDtoList(List<Cancha> cancha);
}
