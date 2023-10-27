package com.cesur.pedidos.domain.daos;

import com.cesur.pedidos.domain.entidades.Pedido;

import java.util.List;

public interface PedidoDAO {
    public List<Pedido> loadByUser(int id_usuario);
}
