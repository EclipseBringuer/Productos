package com.cesur.pedidos.domain.daos;

import com.cesur.pedidos.domain.DBConnection;
import com.cesur.pedidos.domain.entidades.Item;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAOImp implements ItemDAO {

    private Connection connection;
    private static final String QUERY_LOAD_BY_CODE = "SELECT * FROM item WHERE codigo_pedido=?";

    public ItemDAOImp(Connection c) {
        this.connection = c;
    }

    @Override
    public List<Item> loadItemsByCode(String code) {
        List<Item> salida = new ArrayList<>();
        var producto = new ProductoDAOImp(DBConnection.getConnection());

        try (var pst = connection.prepareStatement(QUERY_LOAD_BY_CODE)) {
            pst.setString(1, code);
            var rs = pst.executeQuery();
            while (rs.next()){
                Item i = new Item();
                i.setId(rs.getInt("id"));
                i.setCantidad(rs.getInt("cantidad"));
                i.setCodigoPedido(rs.getString("codigo_pedido"));
                i.setProducto(producto.loadById(rs.getInt("id_producto")));
                salida.add(i);
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return salida;
    }
}
