package com.cesur.pedidos.domain.daos;

import com.cesur.pedidos.domain.entidades.Producto;

public interface ProductoDAO {
    public Producto loadById(int id_prod);
}
