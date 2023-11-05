package com.cesur.pedidos.domain.entidades;

import java.io.Serializable;

/**
 * Clase que representa un producto en la aplicación.
 */
public class Producto implements Serializable {

    private int id; // Identificador único del producto.
    private String nombre; // Nombre del producto.
    private int cantidad; // Cantidad disponible del producto.
    private String precio; // Precio del producto.

    /**
     * Constructor por defecto de la clase Producto.
     */
    public Producto() {

    }

    /**
     * Constructor de la clase que inicializa un producto con nombre, cantidad, precio y un identificador.
     * @param nombre El nombre del producto.
     * @param cantidad La cantidad disponible del producto.
     * @param precio El precio del producto.
     * @param id El identificador único del producto.
     */
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
