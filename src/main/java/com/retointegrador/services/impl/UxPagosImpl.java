package com.retointegrador.services.impl;

import com.retointegrador.entities.Servicio;
import com.retointegrador.repositories.ServicioUxRepository;
import com.retointegrador.services.UxPagos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class UxPagosImpl implements UxPagos {

    @Autowired
    private ServicioUxRepository servicioUxRepository;

    @Override
    public Flux<Servicio> listarServiciosPorCanal(String canal) {

        return this.servicioUxRepository.listarServiciosPorCanal(canal);
    }
}
