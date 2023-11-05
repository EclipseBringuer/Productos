package com.cesur.pedidos.domain.daos;

import com.cesur.pedidos.domain.entidades.Producto;

/**
 * Interfaz que define los métodos para acceder a la información de los productos en la base de datos.
 */
public interface ProductoDAO {
    /**
     * Carga un producto por su identificador desde la base de datos.
     *
     * @param id_prod El identificador del producto a cargar.
     * @return El producto cargado.
     */
    public Producto loadById(int id_prod);
}
