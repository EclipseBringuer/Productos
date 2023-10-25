package com.cesur.pedidos;

import com.cesur.pedidos.domain.entidades.Usuario;

public class Session {
    public static Usuario getUser() {
        return user;
    }

    public static void setUser(Usuario user) {
        Session.user = user;
    }

    private static Usuario user = null;

}
