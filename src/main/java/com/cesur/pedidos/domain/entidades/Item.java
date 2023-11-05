package com.cesur.pedidos.domain.entidades;

import java.io.Serializable;

/**
 * Clase que representa un ítem en la aplicación.
 */
public class Item implements Serializable {
    private int id; // Identificador único del ítem.
    private Producto producto; // Producto asociado al ítem.
    private int cantidad; // Cantidad de productos en el ítem.
    private String codigoPedido; // Código del pedido al que pertenece el ítem.

    /**
     * Constructor por defecto de la clase Item.
     */
    public Item() {

    }

    /**
     * Constructor de la clase que inicializa un ítem con un producto, cantidad, identificador y código de pedido.
     * @param producto El producto asociado al ítem.
     * @param cantidad La cantidad de productos en el ítem.
     * @param id El identificador único del ítem.
     * @param codigoPedido El código del pedido al que pertenece el ítem.
     */
    public Item(Producto producto, int cantidad, int id, String codigoPedido) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.id = id;
        this.codigoPedido = codigoPedido;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(String codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    /**
     * Devuelve una representación en forma de cadena del objeto Item.
     * @return Una cadena que muestra los atributos del ítem.
     */
    @Override
    public String toString(){
        return "Item{" +
                "id=" + id +
                ", producto='" + producto.getNombre() + '\'' +
                ", cantidad='" + cantidad + '\'' +
                ", codigo pedido='" + codigoPedido + '\'' +
                '}';
    }
}
