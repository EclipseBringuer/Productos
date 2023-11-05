package com.cesur.pedidos.domain.daos;

import com.cesur.pedidos.domain.entidades.Producto;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Implementación de la interfaz ProductoDAO para acceder a la información de los productos en la base de datos.
 */
public class ProductoDAOImp implements ProductoDAO {
    private Connection connection;
    private static final String QUERY_LOAD_BY_ID = "SELECT * FROM producto WHERE id=?";

    /**
     * Constructor de la implementación de ProductoDAO.
     *
     * @param c La conexión a la base de datos.
     */
    public ProductoDAOImp(Connection c) {
        this.connection = c;
    }

    /**
     * Carga un producto por su identificador desde la base de datos.
     *
     * @param id_prod El identificador del producto a cargar.
     * @return El producto cargado.
     */
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
