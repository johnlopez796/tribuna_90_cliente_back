package com.cancha.cliente.map;

import com.cancha.cliente.config.MapStructConfig;
import com.cancha.cliente.dto.ReservaBasicDto;
import com.cancha.cliente.dto.ReservaDto;
import com.cancha.cliente.repository.domain.Reserva;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", config = MapStructConfig.class, uses = CanchaMapper.class)
public abstract class ReservaMapper {

    public abstract Reserva toReserva(ReservaDto reservaDto);

    public abstract ReservaDto toReservaDto(Reserva reserva);

    public abstract ReservaBasicDto toReservaBasicDto(Reserva reserva);

    public abstract List<ReservaDto> toListReservaDto(List<Reserva> listReserva);

    public abstract List<ReservaBasicDto> toListReservaBasicDto(List<Reserva> listReserva);
}
