package com.cesur.pedidos;

import com.cesur.pedidos.domain.entidades.Pedido;
import com.cesur.pedidos.domain.entidades.Usuario;

/**
 * Clase que gestiona la sesión del usuario y el pedido actual.
 */
public class Session {
    private static Usuario user = null;
    private static Pedido pedidoActual = null;

    /**
     * Obtiene el usuario actual de la sesión.
     * @return El usuario actual o null si no hay ningún usuario autenticado.
     */
    public static Usuario getUser() { return user; }

    /**
     * Establece el usuario actual de la sesión.
     * @param user El usuario que se autenticará en la sesión.
     */
    public static void setUser(Usuario user) {
        Session.user = user;
    }

    /**
     * Obtiene el pedido actual de la sesión.
     * @return El pedido actual o null si no hay ningún pedido en curso.
     */
    public static Pedido getPedidoActual() {
        return pedidoActual;
    }

    /**
     * Establece el pedido actual de la sesión.
     * @param pedidoActual El pedido que se está gestionando en la sesión.
     */
    public static void setPedidoActual(Pedido pedidoActual) {
        Session.pedidoActual = pedidoActual;
    }
}
