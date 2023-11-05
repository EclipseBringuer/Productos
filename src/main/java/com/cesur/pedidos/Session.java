package com.cesur.pedidos;

import com.cesur.pedidos.domain.entidades.Pedido;
import com.cesur.pedidos.domain.entidades.Usuario;

public class Session {
    private static Usuario user = null;
    private static Pedido pedidoActual = null;

    public static Usuario getUser() { return user; }

    public static void setUser(Usuario user) {
        Session.user = user;
    }

    public static Pedido getPedidoActual() {
        return pedidoActual;
    }

    public static void setPedidoActual(Pedido pedidoActual) {
        Session.pedidoActual = pedidoActual;
    }
}
