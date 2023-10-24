package com.cesur.pedidos.domain.entidades;

import lombok.Data;

@Data
public class Usuario {
    private int id;
    private String nombre;
    private String email;
    private String pass;

    public Usuario(String nombre, String email, String pass) {
        this.nombre = nombre;
        this.email = email;
        this.pass = pass;
    }

    public Usuario() {
        this.nombre = "";
        this.email = "";
        this.pass = "";
    }
}
