package com.cesur.pedidos.domain.daos;

import com.cesur.pedidos.domain.entidades.Item;

import java.util.List;

/**
 * Interfaz que define los métodos para acceder a la información de los ítems en la base de datos.
 */
public interface ItemDAO {
    /**
     * Carga una lista de ítems asociados a un código de pedido.
     *
     * @param code El código de pedido del cual cargar los ítems.
     * @return Una lista de ítems asociados al código de pedido.
     */
    public List<Item> loadItemsByCode(String code);
}
