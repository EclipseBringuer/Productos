package com.cesur.pedidos.domain.entidades;

import java.io.Serializable;

public class Item implements Serializable {
    private int id;
    private Producto producto;
    private int cantidad;
    private String codigoPedido;


    public Item() {

    }

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
