package com.cesur.pedidos.domain.daos;

import com.cesur.pedidos.domain.DBConnection;
import com.cesur.pedidos.domain.entidades.Pedido;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación de la interfaz PedidoDAO para acceder a la información de los pedidos en la base de datos.
 */
public class PedidoDAOImp implements PedidoDAO {
    private Connection connection;
    private static final String QUERY_LOAD_BY_USER = "SELECT * FROM pedido WHERE id_usuario=?";

    /**
     * Constructor de la implementación de PedidoDAO.
     *
     * @param c La conexión a la base de datos.
     */
    public PedidoDAOImp(Connection c) {
        this.connection = c;
    }

    /**
     * Carga una lista de pedidos asociados a un usuario por su identificador desde la base de datos.
     *
     * @param id_usuario El identificador del usuario del cual cargar los pedidos.
     * @return Una lista de pedidos asociados al usuario.
     */
    @Override
    public List<Pedido> loadByUser(int id_usuario) {
        List<Pedido> salida = new ArrayList<>();
        var items = new ItemDAOImp(DBConnection.getConnection());

        try (var pst = connection.prepareStatement(QUERY_LOAD_BY_USER)) {
            pst.setInt(1, id_usuario);
            var rs = pst.executeQuery();
            while (rs.next()) {
                Pedido p = new Pedido();
                p.setId(rs.getInt("id"));
                p.setCodigo(rs.getString("codigo"));
                p.setFecha(rs.getString("fecha"));
                p.setId_usuario(rs.getInt("id_usuario"));
                p.setTotal(rs.getInt("total"));
                p.setItems(items.loadItemsByCode(p.getCodigo()));
                salida.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }

        return salida;
    }
}
