package com.retointegrador.services;

import com.retointegrador.entities.Servicio;
import reactor.core.publisher.Flux;

public interface UxPagos {
    Flux<Servicio> listarServiciosPorCanal(String canal);

}
