package com.cesur.pedidos.domain.entidades;

import java.util.List;

public class Pedido {
    private int id;
    private String codigo;
    private String fecha;
    private int id_usuario;
    private int total;
    private List<Item> items;

    public Pedido() {

    }

    public Pedido(int id, String codigo, String fecha, int id_usuario, int total, List<Item> items) {
        this.id = id;
        this.codigo = codigo;
        this.fecha = fecha;
        this.id_usuario = id_usuario;
        this.total = total;
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
