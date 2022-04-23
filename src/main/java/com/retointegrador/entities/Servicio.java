package com.retointegrador.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Collection;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(value="servicios")
public class Servicio {
    @Id
    private String codigo;
    private String nombre;
    private Collection<Canal> canales;

    public Servicio(String codigo, String nombre){
        this.codigo = codigo;
        this.nombre = nombre;
        this.canales = new ArrayList<Canal>();
    }
}
