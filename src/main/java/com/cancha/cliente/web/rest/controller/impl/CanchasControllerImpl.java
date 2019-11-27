package com.cancha.cliente.web.rest.controller.impl;

import com.cancha.cliente.business.CanchaBusiness;
import com.cancha.cliente.repository.domain.Cancha;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cancha")
public class CanchasControllerImpl {

    private CanchaBusiness canchaBusiness;

    public CanchasControllerImpl(CanchaBusiness canchaBusiness) {
        this.canchaBusiness = canchaBusiness;
    }

    @PostMapping
    public Cancha saveCancha(@RequestBody Cancha cancha){
        return canchaBusiness.saveCancha(cancha);
    }
}
