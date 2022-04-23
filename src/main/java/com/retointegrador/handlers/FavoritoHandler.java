package com.retointegrador.handlers;

import com.retointegrador.entities.Favorito;
import com.retointegrador.services.NeFavoritos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class FavoritoHandler {

    @Autowired
    private NeFavoritos neFavoritos;

    public Mono<ServerResponse> registrar(ServerRequest request){
        return request.bodyToMono(Favorito.class)
                .flatMap(favorito->this.neFavoritos.registrarFavorito(favorito))
                .flatMap(favorito->ServerResponse.ok().body(Mono.just(favorito), Favorito.class));
    }

}
