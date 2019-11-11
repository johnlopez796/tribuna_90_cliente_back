package com.cancha.cliente.service;


import com.cancha.cliente.repository.domain.Cancha;

import java.util.List;

public interface CanchaService {

    List<Cancha> findByEstablecimiento(String idEstablecimiento);
}
