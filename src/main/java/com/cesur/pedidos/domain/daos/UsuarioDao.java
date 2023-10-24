package com.cesur.pedidos.domain.daos;

import com.cesur.pedidos.domain.entidades.Usuario;

public interface UsuarioDao {
    public Usuario load(String email, String pass);

    public Usuario save(Usuario usuario);

    public Usuario update(Usuario usuario);

    public void remove(Usuario usuario);
}
