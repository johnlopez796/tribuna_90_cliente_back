package com.cancha.cliente.dto;

import com.cancha.cliente.repository.domain.Tarifa;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@Data
@NoArgsConstructor
public class HorarioDisponibleDto {
    private CanchaDto canchaDto;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date horaIni;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date horaFin;
    private Tarifa tarifa;
}
