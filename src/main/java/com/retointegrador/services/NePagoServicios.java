package com.retointegrador.services;

import com.retointegrador.entities.Canal;
import com.retointegrador.entities.Servicio;
import com.retointegrador.entities.Transaccion;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface NePagoServicios {

    Mono<Servicio> registrarServicio(Servicio servicio);
    Flux<Servicio> listarServiciosPorCodigo(String codigo);

    Flux<Servicio> listarServicios();
    Mono<Transaccion> pagar(Transaccion transaccion);
}
