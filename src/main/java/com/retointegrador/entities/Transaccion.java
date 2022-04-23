package com.retointegrador.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(value="pagos")
public class Transaccion {

    @Id
    private String codigo;
    private Servicio servicio;
    private Canal canal;
    private String suministro;
    private Double monto;
    private String moneda;
    private Date fecha;

}
