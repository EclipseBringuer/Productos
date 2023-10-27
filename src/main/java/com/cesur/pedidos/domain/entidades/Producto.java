package com.cesur.pedidos.domain.entidades;

import java.io.Serializable;

public class Producto implements Serializable {

    private int id;
    private String nombre;
    private int cantidad;
    private String precio;

    public Producto() {

    }

    public Producto(String nombre, int cantidad, String precio, int id) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.id = id;
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

}
