package com.cesur.pedidos.controllers;

import com.cesur.pedidos.Session;
import com.cesur.pedidos.VentaApplication;
import com.cesur.pedidos.domain.DBConnection;
import com.cesur.pedidos.domain.daos.UsuarioDAOImp;
import com.cesur.pedidos.domain.entidades.Usuario;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controlador para la vista de inicio de sesión.
 */
public class LoginController implements Initializable {
    @FXML
    private TextField txtCorreo; // Campo de entrada para el correo electrónico.
    @FXML
    private Button btnLogin; // Botón para iniciar sesión.
    @FXML
    private Label info; // Etiqueta para mostrar mensajes informativos.
    @FXML
    private Label txtRegistrate; // Etiqueta para permitir la navegación a la vista de registro.
    @FXML
    private PasswordField txtPass; // Campo de entrada para la contraseña.

    /**
     * Inicializa la vista de inicio de sesión.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtCorreo.setText("gabrielrl2004@gmail.com");
        txtPass.setText("15112004");
    }

    /**
     * Maneja el evento de inicio de sesión.
     * @param actionEvent El evento de clic en el botón de inicio de sesión.
     */
    @FXML
    public void logear(ActionEvent actionEvent) {
        var userDAO = new UsuarioDAOImp(DBConnection.getConnection());
        Usuario user = userDAO.loadByAccount(txtCorreo.getText(), txtPass.getText());
        if (user == null) {
            info.setText("Usuario o contraseña incorrecto");
        } else {
            Session.setUser(user);
            VentaApplication.cambiarSecene("main-view.fxml");
        }
    }

    /**
     * Maneja el evento de carga de la vista de registro.
     * @param event El evento de clic en el enlace "Regístrate".
     */
    @FXML
    public void cargarRegistro(Event event) {
        VentaApplication.cambiarSecene("regist-view.fxml");
    }
}