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

public class LoginController implements Initializable {
    @FXML
    private TextField txtCorreo;
    @FXML
    private Button btnLogin;
    @FXML
    private Label info;
    @FXML
    private Label txtRegistrate;
    @FXML
    private PasswordField txtPass;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtCorreo.setText("gabrielrl2004@gmail.com");
        txtPass.setText("15112004");
    }

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

    @FXML
    public void cargarRegistro(Event event) {
        VentaApplication.cambiarSecene("regist-view.fxml");
    }
}