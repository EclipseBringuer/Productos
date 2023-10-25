package com.cesur.pedidos;

import com.cesur.pedidos.domain.entidades.Usuario;

public class Session {
    private static Usuario user = null;

    public static Usuario getUser() {
        return user;
    }

    public static void setUser(Usuario user) {
        Session.user = user;
    }
}
