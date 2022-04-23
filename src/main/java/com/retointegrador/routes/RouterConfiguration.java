package com.retointegrador.routes;

import com.retointegrador.handlers.FavoritoHandler;
import com.retointegrador.handlers.ServicioHandler;
import com.retointegrador.handlers.ServicioUxHandler;
import com.retointegrador.handlers.TransaccionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.*;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class RouterConfiguration {

    @Bean
    public RouterFunction<ServerResponse> servicioRoutes(ServicioHandler servicioHandler){
        return RouterFunctions.nest(RequestPredicates.path("/servicios"),
                RouterFunctions
                        .route(GET("/listar/"), servicioHandler::listarServicios)
                        .andRoute(GET("/listar/{servicio}"), servicioHandler::listarServiciosPorCodigo)
                        .andRoute(POST("/registrar").and(accept(MediaType.APPLICATION_JSON)), servicioHandler::registrarServicio)

        );
    }

    @Bean
    public RouterFunction<ServerResponse> transaccionRoutes(TransaccionHandler transaccionHandler){
        return RouterFunctions.nest(RequestPredicates.path("/transacciones"),
                RouterFunctions
                        .route(POST("/pagar").and(accept(MediaType.APPLICATION_JSON)), transaccionHandler::pagar)

        );
    }

    @Bean
    public RouterFunction<ServerResponse> favoritoRoutes(FavoritoHandler favoritoHandler){
        return RouterFunctions.nest(RequestPredicates.path("/favoritos"),
                RouterFunctions
                        .route(POST("/registrar").and(accept(MediaType.APPLICATION_JSON)), favoritoHandler::registrar)

        );
    }

    @Bean
    public RouterFunction<ServerResponse> servicioUxRoutes(ServicioUxHandler servicioUxHandler){
        return RouterFunctions.nest(RequestPredicates.path("/serviciosux"),
                RouterFunctions
                        .route(GET("/listar").and(accept(MediaType.APPLICATION_JSON)), servicioUxHandler::listarServicios)
                        .andRoute(GET("/listar/{canal}").and(accept(MediaType.APPLICATION_JSON)), servicioUxHandler::listarServicioPorCanal)


        );
    }
}