package com.retointegrador.repositories;

import com.retointegrador.entities.Favorito;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface FavoritoRepository extends ReactiveMongoRepository<Favorito, String> {
}
