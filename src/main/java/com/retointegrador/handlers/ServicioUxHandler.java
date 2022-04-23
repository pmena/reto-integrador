package com.retointegrador.handlers;

import com.retointegrador.services.UxPagos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public class ServicioUxHandler {

    @Autowired
    private UxPagos uxPagos;

    public Mono<ServerResponse> registrar(ServerRequest request){
        /*
        return request.bodyToMono(Servicio.class)
                .flatMap(servicio->this.uxPagos.listarServiciosPorCanal("X"))
                .flatMap(servicio->ServerResponse.ok().body(Mono.just(servicio), Servicio.class));


         */
        return  null;
    }
}
