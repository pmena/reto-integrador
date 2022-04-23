package com.retointegrador.repositories;

import com.retointegrador.entities.Favorito;
import reactor.core.publisher.Mono;

public interface FavoritoUxRepository {

    Mono<Favorito> registrarFavorito(Favorito favorito);

}
