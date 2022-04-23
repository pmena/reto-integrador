package com.retointegrador.repositories;

import com.retointegrador.entities.Servicio;
import com.retointegrador.entities.Transaccion;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ServicioUxRepository{

    Flux<Servicio> listarServiciosPorCanal(String canal);

    Flux<Servicio> listarServicios();

    Mono<Transaccion> pagar(Transaccion transaccion);
}
