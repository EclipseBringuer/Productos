package com.cesur.pedidos.controllers;

import com.cesur.pedidos.VentaApplication;
import com.cesur.pedidos.domain.DBConnection;
import com.cesur.pedidos.domain.daos.UsuarioDAOImp;
import com.cesur.pedidos.domain.entidades.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * Controlador para la vista de registro de usuarios.
 */
public class RegisterController implements Initializable {
    @javafx.fxml.FXML
    private Label info; // Etiqueta para mostrar mensajes informativos.
    @javafx.fxml.FXML
    private TextField txtCorreo; // Campo de entrada para el correo electrónico.
    @javafx.fxml.FXML
    private PasswordField txtPass; // Campo de entrada para la contraseña.
    @javafx.fxml.FXML
    private TextField txtNombre; // Campo de entrada para el nombre del usuario.
    @javafx.fxml.FXML
    private Button btnRegist; // Botón para registrar un usuario.
    @javafx.fxml.FXML
    private Button btnVolver; // Botón para volver a la vista de inicio de sesión.

    /**
     * Inicializa la vista de registro.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /**
     * Maneja el evento de registro de usuario.
     * @param actionEvent El evento de clic en el botón de registro.
     */
    @javafx.fxml.FXML
    public void registrarUsuario(ActionEvent actionEvent) {
        if (txtCorreo.getText().contains("@gmail.com")) {
            if (!Objects.equals(txtNombre.getText(), "") && !Objects.equals(txtCorreo.getText(), "") && !Objects.equals(txtPass.getText(), "")) {
                Usuario user = new Usuario();
                user.setNombre(txtNombre.getText());
                user.setEmail(txtCorreo.getText());
                user.setPass(txtPass.getText());
                var userDAO = new UsuarioDAOImp(DBConnection.getConnection());
                try {
                    Usuario salida = userDAO.save(user);
                    if (salida != null) {
                        VentaApplication.cambiarSecene("login-view.fxml");
                    } else {
                        info.setText("Error, fallo al registrate");
                    }
                } catch (RuntimeException e) {
                    info.setText("Usuario ya existente");
                }
            } else {
                info.setText("Rellena todos los campos");
            }
        } else {
            info.setText("Correo invalido");
        }
    }

    /**
     * Maneja el evento de volver a la vista de inicio de sesión.
     * @param actionEvent El evento de clic en el botón de volver.
     */
    @javafx.fxml.FXML
    public void volver(ActionEvent actionEvent) {
        VentaApplication.cambiarSecene("login-view.fxml");
    }
}