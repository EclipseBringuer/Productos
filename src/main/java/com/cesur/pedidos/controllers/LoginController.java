package com.cesur.pedidos.controllers;

import com.cesur.pedidos.domain.DBConnection;
import com.cesur.pedidos.domain.daos.UsuarioDAOImp;
import com.cesur.pedidos.domain.entidades.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private TextField txtCorreo;
    @FXML
    private TextField txtPass;
    @FXML
    private Button btnLogin;
    @FXML
    private Label info;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }


    @FXML
    public void logear(ActionEvent actionEvent) {
        var userDAO = new UsuarioDAOImp(DBConnection.getConnection());
        Usuario user = userDAO.load(txtCorreo.getText(),txtPass.getText());
        info.setText(user.toString());
    }
}