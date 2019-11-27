package com.cancha.cliente.business.impl;

import com.cancha.cliente.business.CanchaBusiness;
import com.cancha.cliente.repository.domain.Cancha;
import com.cancha.cliente.service.CanchaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CanchaBusinessImpl implements CanchaBusiness{

    private CanchaService canchaService;

    public CanchaBusinessImpl(CanchaService canchaService) {
        this.canchaService = canchaService;
    }

    public Cancha saveCancha(Cancha cancha){
        return canchaService.saveCancha(cancha);
    }
}
