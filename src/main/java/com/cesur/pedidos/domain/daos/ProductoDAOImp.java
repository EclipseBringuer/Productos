package com.cesur.pedidos.domain.daos;

import com.cesur.pedidos.domain.entidades.Producto;

import java.sql.Connection;
import java.sql.SQLException;

public class ProductoDAOImp implements ProductoDAO {
    private Connection connection;
    private static final String QUERY_LOAD_BY_ID = "SELECT * FROM producto WHERE id=?";

    public ProductoDAOImp(Connection c) {
        this.connection = c;
    }

    @Override
    public Producto loadById(int id_prod) {
        Producto p = new Producto();
        try (var pst = connection.prepareStatement(QUERY_LOAD_BY_ID)) {
            pst.setInt(1, id_prod);
            var rs = pst.executeQuery();
            rs.next();
            p.setId(rs.getInt("id"));
            p.setNombre(rs.getString("nombre"));
            p.setCantidad(rs.getInt("cantidad"));
            p.setPrecio(rs.getString("precio"));

        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return p;
    }
}
