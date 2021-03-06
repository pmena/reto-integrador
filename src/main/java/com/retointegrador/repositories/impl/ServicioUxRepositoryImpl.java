package com.retointegrador.repositories.impl;

import com.retointegrador.core.exceptions.SubscriberBaseException;
import com.retointegrador.entities.Canal;
import com.retointegrador.entities.Servicio;
import com.retointegrador.entities.Transaccion;
import com.retointegrador.repositories.ServicioUxRepository;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;
import reactor.util.retry.Retry;

import java.time.Duration;

@Slf4j
@Repository
public class ServicioUxRepositoryImpl implements ServicioUxRepository {

    private final WebClient client;

    public ServicioUxRepositoryImpl( WebClient.Builder builder,
                                     @Value( "${application.urlApiServicios:http://localhost:8080/servicios}" ) String urlApiServicios){
        HttpClient client = HttpClient.create()
                .responseTimeout(Duration.ofSeconds(5));
        this.client = builder.baseUrl(urlApiServicios)
                .clientConnector(new ReactorClientHttpConnector(client))
                .build();

    }

    @Override
    public Flux<Servicio> listarServiciosPorCanal(String strCanal) {

        return this.client.get().uri("/listar/").accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Servicio.class)
                .filter(servicio -> {
                                        if(servicio.getCanales() != null){
                                            for(Canal objCanal : servicio.getCanales()){
                                                if(strCanal.equals(objCanal.getCodigo())){
                                                    return true;
                                                }
                                            }
                                        }
                                        return false;
                                    }
                        );
    }

    @Override
    public Flux<Servicio> listarServicios() {
        return this.client.get().uri("/listar/").accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Servicio.class);
    }

}
