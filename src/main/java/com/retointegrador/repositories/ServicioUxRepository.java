package com.retointegrador.repositories;

import com.retointegrador.entities.Servicio;
import reactor.core.publisher.Flux;

public interface ServicioUxRepository{

    Flux<Servicio> listarServiciosPorCanal(String canal);

    Flux<Servicio> listarServicios();

}
