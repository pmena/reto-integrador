package com.retointegrador.routes;

import com.retointegrador.handlers.ServicioHandler;
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
                        .route(GET("/listar/{canal}"), servicioHandler::listarServiciosPorCanal)
                        .andRoute(POST("/registrar").and(accept(MediaType.APPLICATION_JSON)), servicioHandler::registrarServicio)

        );
    }
}