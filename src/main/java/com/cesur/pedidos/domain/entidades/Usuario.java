package com.cesur.pedidos.domain.entidades;

import lombok.Data;

@Data
public class Usuario {
    private int id;
    private String nombre;
    private String email;
    private String pass;
}
