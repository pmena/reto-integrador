package com.retointegrador.entities;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Transaccion {

    @Id
    private int id;
    private Servicio servicio;
    private String suministro;
    private Double monto;
    private Date fecha;

}
