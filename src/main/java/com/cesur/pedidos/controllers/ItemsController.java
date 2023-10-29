package com.cesur.pedidos.controllers;

import com.cesur.pedidos.Session;
import com.cesur.pedidos.VentaApplication;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;

public class ItemsController implements Initializable {
    @javafx.fxml.FXML
    private Label info;
    @javafx.fxml.FXML
    private Button btnVolver;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        info.setText(Session.getPedidoActual().getItems().toString());
    }

    @javafx.fxml.FXML
    public void volver(ActionEvent actionEvent) {
        VentaApplication.loadFXML("fxml/main-view.fxml",800,600,true,true);
    }
}