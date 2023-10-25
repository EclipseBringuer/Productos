package com.cesur.pedidos.controllers;

import com.cesur.pedidos.Session;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;

public class MainView implements Initializable {
    @javafx.fxml.FXML
    private Label texto;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        texto.setText(Session.getUser().toString());
    }
}