package com.retointegrador.services.impl;

import com.retointegrador.entities.Favorito;
import com.retointegrador.repositories.FavoritoRepository;
import com.retointegrador.repositories.TransaccionRepository;
import com.retointegrador.services.NeFavoritos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class NeFavoritosImpl implements NeFavoritos {

    @Autowired
    private FavoritoRepository favoritoRepository;

    @Override
    public Mono<Favorito> registrarFavorito(Favorito favorito){
        return this.favoritoRepository.save(favorito);
    }

}
