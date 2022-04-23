package com.retointegrador.services.impl;

import com.retointegrador.entities.Favorito;
import com.retointegrador.entities.Servicio;
import com.retointegrador.entities.Transaccion;
import com.retointegrador.repositories.FavoritoUxRepository;
import com.retointegrador.repositories.ServicioUxRepository;
import com.retointegrador.repositories.TransaccionUxRepository;
import com.retointegrador.services.UxPagos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class UxPagosImpl implements UxPagos {

    @Autowired
    private ServicioUxRepository servicioUxRepository;

    @Autowired
    private TransaccionUxRepository transaccionUxRepository;

    @Autowired
    private FavoritoUxRepository favoritoUxRepository;

    @Override
    public Flux<Servicio> listarServiciosPorCanal(String canal) {

        return this.servicioUxRepository.listarServiciosPorCanal(canal);
    }

    @Override
    public Flux<Servicio> listarServicios() {
        return this.servicioUxRepository.listarServicios();
    }

    @Override
    public Mono<Transaccion> pagar(Transaccion transaccion) {
        transaccion.setOrigen("API UX");
        Mono<Transaccion> trx = this.transaccionUxRepository.pagar(transaccion);
        Mono<Favorito> favorito = null;
        if(trx != null && transaccion.getFavorito() != null){

            transaccion.getFavorito().setOrigen("API UX");
            transaccion.getFavorito().setServicio(transaccion.getServicio());
            this.favoritoUxRepository.registrarFavorito(transaccion.getFavorito())
                    .cache(Duration.ofSeconds(5))
                    .subscribe();
        }
        return trx;
    }
}
