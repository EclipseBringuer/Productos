package com.cesur.pedidos.controllers;

import com.cesur.pedidos.Session;
import com.cesur.pedidos.VentaApplication;
import com.cesur.pedidos.domain.DBConnection;
import com.cesur.pedidos.domain.daos.PedidoDAOImp;
import com.cesur.pedidos.domain.entidades.Pedido;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @javafx.fxml.FXML
    private TableView<Pedido> table;
    @javafx.fxml.FXML
    private TableColumn<Pedido, String> columnCodigo;
    @javafx.fxml.FXML
    private TableColumn<Pedido, String> columnFecha;
    @javafx.fxml.FXML
    private TableColumn<Pedido, String> columnPrecio;
    @javafx.fxml.FXML
    private Label txtUsuario;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtUsuario.setText(txtUsuario.getText() + Session.getUser().getNombre());
        var pedidoDAO = new PedidoDAOImp(DBConnection.getConnection());
        var pedidos = pedidoDAO.loadByUser(Session.getUser().getId());
        table.getItems().addAll(pedidos);

        columnFecha.setCellValueFactory((fila) -> {
            String fecha = fila.getValue().getFecha();
            return new SimpleStringProperty(fecha);
        });

        columnCodigo.setCellValueFactory((fila) -> {
            String codigo = fila.getValue().getCodigo();
            return new SimpleStringProperty(codigo);
        });

        columnPrecio.setCellValueFactory((fila) -> {
            String total = fila.getValue().getTotal() + " €";
            return new SimpleStringProperty(total);
        });

        table.getSelectionModel().selectedItemProperty().addListener(
                (observable, vOld, vNew) -> {
                    Session.setPedidoActual(table.getSelectionModel().getSelectedItem());
                    VentaApplication.loadFXML("fxml/items-view.fxml",900,600,true,true);
                }
        );

    }
}