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

public class RegisterController implements Initializable {
    @javafx.fxml.FXML
    private Label info;
    @javafx.fxml.FXML
    private TextField txtCorreo;
    @javafx.fxml.FXML
    private PasswordField txtPass;
    @javafx.fxml.FXML
    private TextField txtNombre;
    @javafx.fxml.FXML
    private Button btnRegist;
    @javafx.fxml.FXML
    private Button btnVolver;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    @javafx.fxml.FXML
    public void registrarUsuario(ActionEvent actionEvent) {
        if (!Objects.equals(txtNombre.getText(), "") && !Objects.equals(txtCorreo.getText(), "") && !Objects.equals(txtPass.getText(), "")) {
            Usuario user = new Usuario();
            user.setNombre(txtNombre.getText());
            user.setEmail(txtCorreo.getText());
            user.setPass(txtPass.getText());
            var userDAO = new UsuarioDAOImp(DBConnection.getConnection());
            try {
                Usuario salida = userDAO.save(user);
                if (salida != null) {
                    VentaApplication.loadFXML("fxml/login-view.fxml");
                } else {
                    info.setText("Error, fallo al registrate");
                }
            }catch (RuntimeException e){
                info.setText("Usuario ya existente");
            }
        } else {
            info.setText("Rellena todos los campos");
        }
    }

    @javafx.fxml.FXML
    public void volver(ActionEvent actionEvent) {
        VentaApplication.loadFXML("fxml/login-view.fxml");
    }
}