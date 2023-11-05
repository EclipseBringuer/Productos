package com.cesur.pedidos.domain.daos;

import com.cesur.pedidos.domain.entidades.Pedido;

import java.util.List;

/**
 * Interfaz que define los métodos para acceder a la información de los pedidos en la base de datos.
 */
public interface PedidoDAO {
    /**
     * Carga una lista de pedidos asociados a un usuario por su identificador.
     *
     * @param id_usuario El identificador del usuario del cual cargar los pedidos.
     * @return Una lista de pedidos asociados al usuario.
     */
    public List<Pedido> loadByUser(int id_usuario);
}
