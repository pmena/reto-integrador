package com.retointegrador.handlers;

import com.retointegrador.entities.Servicio;
import com.retointegrador.services.NePagoServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class ServicioHandler {

    @Autowired
    private NePagoServicios nePagoServiciosImpl;

    public Mono<ServerResponse> listarServicios(ServerRequest request){
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body (this.nePagoServiciosImpl.listarServicios(), Servicio.class);
    }
    public Mono<ServerResponse>listarServiciosPorCodigo(ServerRequest request){

        var codigo = request.pathVariable("servicio");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body (this.nePagoServiciosImpl.listarServiciosPorCodigo(codigo), Servicio.class);
    }
    public Mono<ServerResponse> registrarServicio(ServerRequest request){
        return request.bodyToMono(Servicio.class)
                .flatMap(servicio->this.nePagoServiciosImpl.registrarServicio(servicio))
                .flatMap(servicio->ServerResponse.ok().body(Mono.just(servicio), Servicio.class));
    }

}
