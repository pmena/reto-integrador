package com.retointegrador.services.impl;

import com.retointegrador.entities.Servicio;
import com.retointegrador.entities.Transaccion;
import com.retointegrador.repositories.ServicioUxRepository;
import com.retointegrador.services.UxPagos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UxPagosImpl implements UxPagos {

    @Autowired
    private ServicioUxRepository servicioUxRepository;

    @Override
    public Flux<Servicio> listarServiciosPorCanal(String canal) {

        return this.servicioUxRepository.listarServiciosPorCanal(canal);
    }

    @Override
    public Flux<Servicio> listarServicios() {
        return this.servicioUxRepository.listarServicios();
    }

    @Override
    public Mono<Transaccion> pagar(Transaccion transaccion) {
        return null;
    }
}
