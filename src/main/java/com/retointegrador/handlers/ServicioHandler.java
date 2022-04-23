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

    public Mono<ServerResponse> listarServiciosPorCanal(ServerRequest request){

        var canal = request.pathVariable("canal");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body (this.nePagoServiciosImpl.listarServiciosPorCanal(canal), Servicio.class);
    }
    public Mono<ServerResponse> registrarServicio(ServerRequest request){

        //var servicio= request.bodyToMono(Servicio.class);

        return request.bodyToMono(Servicio.class)
                .flatMap(servicio->this.nePagoServiciosImpl.registrarServicio(servicio))
                .flatMap(servicio->ServerResponse.ok().body(Mono.just(servicio), Servicio.class));

        /*
        var codigo = request.pathVariable("codigo");
        var nombre = request.pathVariable("nombre");
        new Servicio(codigo, nombre)
*/

/*
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body (this.nePagoServiciosImpl.registrarServicio(servicio), Servicio.class);
        */
    }

}
