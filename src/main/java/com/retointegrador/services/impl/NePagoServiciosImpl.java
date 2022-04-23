package com.retointegrador.services.impl;

import com.retointegrador.entities.Servicio;
import com.retointegrador.entities.Transaccion;
import com.retointegrador.repositories.ServicioRepository;
import com.retointegrador.repositories.TransaccionRepository;
import com.retointegrador.services.NePagoServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class NePagoServiciosImpl implements NePagoServicios {

    @Autowired
    private ServicioRepository servicioRepository;

    @Autowired
    private TransaccionRepository transaccionRepository;

    @Override
    public Mono<Servicio> registrarServicio(Servicio servicio) {
        return this.servicioRepository.save(servicio);
    }

    @Override
    public Flux<Servicio> listarServiciosPorCodigo(String canal) {

        return this.servicioRepository.findAllByCodigo(canal);
    }

    @Override
    public Flux<Servicio> listarServicios() {
        return this.servicioRepository.findAll();
    }

    @Override
    public Mono<Transaccion> pagar(Transaccion transaccion) {
        return this.transaccionRepository.save(transaccion);
    }

}
