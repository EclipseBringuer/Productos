package com.cesur.pedidos.domain.daos;

import com.cesur.pedidos.domain.entidades.Usuario;

import java.sql.*;

public class UsuarioDAOImp implements UsuarioDao {

    private Connection connection;

    private static final String QUERY_SAVE = "INSERT INTO usuario(nombre,email,contraseña) VALUES (?,?,?)";
    private static final String QUERY_LOAD = "SELECT * FROM usuario WHERE email=? AND contraseña=?";
    private static final String QUERY_REMOVE = "DELETE FROM usuario WHERE id=?";
    private static final String QUERY_UPDATE = "";

    public UsuarioDAOImp(Connection c) {
        this.connection = c;
    }

    @Override
    public Usuario loadByAccount(String email, String pass) {
        Usuario salida = null;
        try (var pst = connection.prepareStatement(QUERY_LOAD)) {
            pst.setString(1, email);
            pst.setString(2, pass);
            var rs = pst.executeQuery();
            if (rs.next()) {
                salida = new Usuario();
                salida.setId(rs.getInt("id"));
                salida.setNombre(rs.getString("nombre"));
                salida.setEmail(rs.getString("email"));
                salida.setPass(rs.getString("contraseña"));
            } else {
                System.out.println("Usuario no encontrado");
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return salida;
    }

    @Override
    public Usuario save(Usuario usuario) {
        Usuario salida = null;
        try (PreparedStatement pst = connection.prepareStatement(QUERY_SAVE, Statement.RETURN_GENERATED_KEYS)) {
            pst.setString(1, usuario.getNombre());
            pst.setString(2, usuario.getEmail());
            pst.setString(3, usuario.getPass());

            int result = pst.executeUpdate();//el resultado son el numero de filas afectadas

            if (result == 1) {
                ResultSet rs = pst.getGeneratedKeys();
                rs.next();
                salida = usuario;
                salida.setId(rs.getInt(1));
            } else {
                System.out.println("Error al registrar usuario");
            }

        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return salida;
    }

    @Override
    public Usuario update(Usuario usuario) {
        return null;
    }

    @Override
    public void remove(Usuario usuario) {
        try (var pst = connection.prepareStatement(QUERY_REMOVE)) {
            pst.setInt(1, usuario.getId());

            var result = pst.executeUpdate();

            if (result > 0)
                System.out.println("Usuario eliminado correctamente");
            else
                System.out.println("Error al eliminar el usuario");

        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
