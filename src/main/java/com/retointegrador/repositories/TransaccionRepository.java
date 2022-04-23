package com.retointegrador.repositories;

import com.retointegrador.entities.Transaccion;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TransaccionRepository extends ReactiveMongoRepository<Transaccion, String> {
}
