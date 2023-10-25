package com.cesur.pedidos.domain.entidades;

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
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}
