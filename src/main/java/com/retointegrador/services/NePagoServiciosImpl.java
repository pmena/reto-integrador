package com.retointegrador.services;

import com.retointegrador.entities.Servicio;
import com.retointegrador.repositories.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class NePagoServiciosImpl implements  NePagoServicios {

    @Autowired
    private ServicioRepository servicioRepository;

    @Override
    public Mono<Servicio> registrarServicio(Servicio servicio) {
        return this.servicioRepository.save(servicio);
    }

    @Override
    public Flux<Servicio> listarServiciosPorCanal(String canal) {

        return this.servicioRepository.findAllByCanales(canal);
    }

}
