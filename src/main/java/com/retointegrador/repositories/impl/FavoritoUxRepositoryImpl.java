package com.retointegrador.repositories.impl;

import com.retointegrador.entities.Favorito;
import com.retointegrador.repositories.FavoritoUxRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;

@Slf4j
@Repository
public class FavoritoUxRepositoryImpl implements FavoritoUxRepository {

    private final WebClient client;

    public FavoritoUxRepositoryImpl( WebClient.Builder builder,
                                     @Value( "${application.urlApiFavoritos:http://localhost:8080/favoritos}" ) String urlApiFavoritos){
        HttpClient client = HttpClient.create()
                .responseTimeout(Duration.ofSeconds(5));
        this.client = builder.baseUrl(urlApiFavoritos)
                .clientConnector(new ReactorClientHttpConnector(client))
                .build();
    }

    @Override
    public Mono<Favorito> registrarFavorito(Favorito favorito) {
        return this.client
                .post()
                .uri("/registrar/")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(favorito), Favorito.class)
                .retrieve()
                .bodyToMono(Favorito.class);
    }
}
