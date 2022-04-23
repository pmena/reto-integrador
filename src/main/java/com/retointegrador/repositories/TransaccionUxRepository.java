package com.retointegrador.repositories;

import com.retointegrador.entities.Transaccion;
import reactor.core.publisher.Mono;

public interface TransaccionUxRepository {
    Mono<Transaccion> pagar(Transaccion transaccion);
}
