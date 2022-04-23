package com.retointegrador.handlers;

import com.retointegrador.entities.Servicio;
import com.retointegrador.entities.Transaccion;
import com.retointegrador.services.NePagoServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class TransaccionHandler {

    @Autowired
    private NePagoServicios nePagoServiciosImpl;

    public Mono<ServerResponse> pagar(ServerRequest request){
        return request.bodyToMono(Transaccion.class)
                .flatMap(transaccion->this.nePagoServiciosImpl.pagar(transaccion))
                .flatMap(transaccion->ServerResponse.ok().body(Mono.just(transaccion), Transaccion.class));
    }
}
