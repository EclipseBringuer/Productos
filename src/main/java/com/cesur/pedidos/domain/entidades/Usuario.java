package com.cesur.pedidos.domain.entidades;

import java.io.Serializable;

/**
 * Clase que representa a un usuario en la aplicación.
 */
public class Usuario implements Serializable {
    private int id; // Identificador único del usuario.
    private String nombre; // Nombre del usuario.
    private String email; // Correo electrónico del usuario.
    private String pass; // Contraseña del usuario.

    /**
     * Constructor de la clase que inicializa un usuario con nombre, correo electrónico y contraseña.
     * @param nombre El nombre del usuario.
     * @param email El correo electrónico del usuario.
     * @param pass La contraseña del usuario.
     */
    public Usuario(String nombre, String email, String pass) {
        this.nombre = nombre;
        this.email = email;
        this.pass = pass;
    }

    /**
     * Constructor de la clase que inicializa un usuario con valores predeterminados.
     */
    public Usuario() {
        this.nombre = "";
        this.email = "";
        this.pass = "";
    }

    /**
     * Devuelve una representación en forma de cadena del objeto Usuario.
     * @return Una cadena que muestra los atributos del usuario.
     */
    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}
