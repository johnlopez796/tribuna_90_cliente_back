package com.cancha.cliente.service.impl;

import com.cancha.cliente.repository.ReservaRepository;
import com.cancha.cliente.service.ReservaService;
import org.springframework.stereotype.Service;

@Service
public class ReservaServiceImpl implements ReservaService{

    private ReservaRepository reservaRepository;

    public ReservaServiceImpl(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }
}
