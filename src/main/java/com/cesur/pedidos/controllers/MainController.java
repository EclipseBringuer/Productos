package com.cesur.pedidos.controllers;

import com.cesur.pedidos.Session;
import com.cesur.pedidos.domain.DBConnection;
import com.cesur.pedidos.domain.daos.PedidoDAOImp;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @javafx.fxml.FXML
    private TableView table;
    @javafx.fxml.FXML
    private TableColumn columnCodigo;
    @javafx.fxml.FXML
    private TableColumn columnFecha;
    @javafx.fxml.FXML
    private TableColumn columnPrecio;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        var pedidoDAO = new PedidoDAOImp(DBConnection.getConnection());
        var pedidos = pedidoDAO.loadByUser(Session.getUser().getId());
        table.getItems().addAll(pedidos);

    }
}