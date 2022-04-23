package com.retointegrador.services;

import com.retointegrador.entities.Servicio;
import com.retointegrador.entities.Transaccion;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UxPagos {
    Flux<Servicio> listarServiciosPorCanal(String canal);

    Flux<Servicio> listarServicios();

    Mono<Transaccion> pagar(Transaccion transaccion);

}
