package com.cesur.pedidos.domain.daos;

import com.cesur.pedidos.domain.entidades.Usuario;

/**
 * Interfaz que define los métodos para acceder a la información de los usuarios en la base de datos.
 */
public interface UsuarioDao {
    /**
     * Carga un usuario por su correo electrónico y contraseña.
     *
     * @param email El correo electrónico del usuario.
     * @param pass La contraseña del usuario.
     * @return El usuario cargado, o null si no se encontró ningún usuario con las credenciales especificadas.
     */
    public Usuario loadByAccount(String email, String pass);

    /**
     * Guarda un nuevo usuario en la base de datos.
     *
     * @param usuario El usuario a guardar.
     * @return El usuario guardado, o null si hubo un error durante el proceso de guardado.
     */
    public Usuario save(Usuario usuario);

    /**
     * Actualiza la información de un usuario en la base de datos.
     *
     * @param usuario El usuario a actualizar.
     * @return El usuario actualizado, o null si hubo un error durante el proceso de actualización.
     */
    public Usuario update(Usuario usuario);

    /**
     * Elimina un usuario de la base de datos.
     *
     * @param usuario El usuario a eliminar.
     */
    public void remove(Usuario usuario);
}
