package com.cesur.pedidos.domain.daos;

import com.cesur.pedidos.domain.entidades.Usuario;
import java.sql.*;

/**
 * Implementación de la interfaz UsuarioDao para acceder a la información de los usuarios en la base de datos.
 */
public class UsuarioDAOImp implements UsuarioDao {
    private Connection connection;
    private static final String QUERY_SAVE = "INSERT INTO usuario(nombre,email,contraseña) VALUES (?,?,?)";
    private static final String QUERY_LOAD = "SELECT * FROM usuario WHERE email=? AND contraseña=?";
    private static final String QUERY_REMOVE = "DELETE FROM usuario WHERE id=?";
    private static final String QUERY_UPDATE = "";

    /**
     * Constructor de la implementación de UsuarioDao.
     *
     * @param c La conexión a la base de datos.
     */
    public UsuarioDAOImp(Connection c) {
        this.connection = c;
    }

    /**
     * Carga un usuario por su correo electrónico y contraseña desde la base de datos.
     *
     * @param email El correo electrónico del usuario.
     * @param pass La contraseña del usuario.
     * @return El usuario cargado, o null si no se encontró ningún usuario con las credenciales especificadas.
     */
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

    /**
     * Guarda un nuevo usuario en la base de datos.
     *
     * @param usuario El usuario a guardar.
     * @return El usuario guardado, o null si hubo un error durante el proceso de guardado.
     */
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

    /**
     * Actualiza la información de un usuario en la base de datos.
     *
     * @param usuario El usuario a actualizar.
     * @return El usuario actualizado, o null si hubo un error durante el proceso de actualización.
     */
    @Override
    public Usuario update(Usuario usuario) {
        return null;
    }

    /**
     * Elimina un usuario de la base de datos.
     *
     * @param usuario El usuario a eliminar.
     */
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
