package com.cesur.pedidos.domain.entidades;

public class Item {
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
}
