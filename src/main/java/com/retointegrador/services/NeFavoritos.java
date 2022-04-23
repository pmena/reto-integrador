package com.retointegrador.services;

import com.retointegrador.entities.Favorito;
import reactor.core.publisher.Mono;

public interface NeFavoritos {

    Mono<Favorito> registrarFavorito(Favorito favorito);
}
