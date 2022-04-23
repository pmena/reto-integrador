package com.retointegrador.repositories;

import com.retointegrador.entities.Canal;
import com.retointegrador.entities.Servicio;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

import java.util.Collection;

public interface ServicioRepository extends ReactiveMongoRepository<Servicio, String> {

    Flux<Servicio> findAllByCanales(String canal);

}
