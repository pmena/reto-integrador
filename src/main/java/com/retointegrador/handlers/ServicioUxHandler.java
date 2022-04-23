package com.retointegrador.handlers;

import com.retointegrador.entities.Servicio;
import com.retointegrador.entities.Transaccion;
import com.retointegrador.services.UxPagos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class ServicioUxHandler {

    @Autowired
    private UxPagos uxPagos;
    public Mono<ServerResponse> listarServicioPorCanal(ServerRequest request){
        var canal = request.pathVariable("canal");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body (this.uxPagos.listarServiciosPorCanal(canal), Servicio.class);
    }

    public Mono<ServerResponse> listarServicios(ServerRequest request){
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body (this.uxPagos.listarServicios(), Servicio.class);
    }

    public Mono<ServerResponse> pagar(ServerRequest request){
        return request.bodyToMono(Transaccion.class)
                .flatMap(transaccion -> this.uxPagos.pagar(transaccion))
                .flatMap(transaccion -> ServerResponse.ok().body(Mono.just(transaccion), Transaccion.class));
    }
}
