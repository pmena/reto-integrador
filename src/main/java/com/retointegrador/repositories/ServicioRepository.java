package com.retointegrador.repositories;

import com.retointegrador.entities.Servicio;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface ServicioRepository extends ReactiveMongoRepository<Servicio, String> {

    Flux<Servicio> findAllByCodigo(String canal);

}
