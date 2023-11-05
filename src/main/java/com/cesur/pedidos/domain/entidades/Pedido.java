package com.cesur.pedidos.domain.entidades;

import java.io.Serializable;
import java.util.List;

/**
 * Clase que representa un pedido en la aplicación.
 */
public class Pedido implements Serializable {
    private int id; // Identificador único del pedido.
    private String codigo; // Código del pedido.
    private String fecha; // Fecha en que se realizó el pedido.
    private int id_usuario; // Identificador del usuario que realizó el pedido.
    private int total; // Total del pedido.
    private List<Item> items; // Lista de elementos (ítems) incluidos en el pedido.

    /**
     * Constructor por defecto de la clase Pedido.
     */
    public Pedido() {

    }

    /**
     * Constructor de la clase que inicializa un pedido con un identificador, código, fecha, identificador de usuario, total y lista de ítems.
     * @param id El identificador único del pedido.
     * @param codigo El código del pedido.
     * @param fecha La fecha en que se realizó el pedido.
     * @param id_usuario El identificador del usuario que realizó el pedido.
     * @param total El total del pedido.
     * @param items La lista de ítems incluidos en el pedido.
     */
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
