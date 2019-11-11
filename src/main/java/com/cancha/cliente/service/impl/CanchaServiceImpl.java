package com.cancha.cliente.service.impl;

import com.cancha.cliente.repository.CanchaRepository;
import com.cancha.cliente.repository.domain.Cancha;
import com.cancha.cliente.repository.domain.Establecimiento;
import com.cancha.cliente.service.CanchaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CanchaServiceImpl implements CanchaService{

    private CanchaRepository canchaRepository;

    public CanchaServiceImpl(CanchaRepository canchaRepository) {
        this.canchaRepository = canchaRepository;
    }

    @Override
    public List<Cancha> findByEstablecimiento(String idEstablecimiento){
        return canchaRepository.findByEstablecimiento(new Establecimiento(idEstablecimiento));
    }
}
