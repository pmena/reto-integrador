package com.retointegrador.repositories.impl;

import com.retointegrador.entities.Transaccion;
import com.retointegrador.repositories.TransaccionUxRepository;
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
public class TransaccionUxRepositoryImpl implements TransaccionUxRepository {

    private final WebClient client;

    public TransaccionUxRepositoryImpl( WebClient.Builder builder,
                                     @Value( "${application.urlApiTransacciones:http://localhost:8080/transacciones}" ) String urlApiTransacciones){
        HttpClient client = HttpClient.create()
                .responseTimeout(Duration.ofSeconds(5));
        this.client = builder.baseUrl(urlApiTransacciones)
                .clientConnector(new ReactorClientHttpConnector(client))
                .build();

    }

    @Override
    public Mono<Transaccion> pagar(Transaccion transaccion) {
        return this.client
                .post()
                .uri("/pagar/")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(transaccion), Transaccion.class)
                .retrieve()
                .bodyToMono(Transaccion.class);
    }

}
