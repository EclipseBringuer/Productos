package com.cesur.pedidos.controllers;

import com.cesur.pedidos.Session;
import com.cesur.pedidos.VentaApplication;
import com.cesur.pedidos.domain.DBConnection;
import com.cesur.pedidos.domain.daos.PedidoDAOImp;
import com.cesur.pedidos.domain.entidades.Item;
import com.cesur.pedidos.domain.entidades.Pedido;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

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
    @javafx.fxml.FXML
    private HBox userMenu;
    @javafx.fxml.FXML
    private ImageView imgSalir;
    @javafx.fxml.FXML
    private TableColumn<Item, String> columnProducto;
    @javafx.fxml.FXML
    private TableColumn<Item, String> columnPrecioProducto;
    @javafx.fxml.FXML
    private TableColumn<Item, String> columnCantidad;
    @javafx.fxml.FXML
    private TableView<Item> tableItem;
    @javafx.fxml.FXML
    private Label infoPedido;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        txtUsuario.setText(txtUsuario.getText() + Session.getUser().getNombre());
        ObservableList<Item> items = tableItem.getItems();
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
                    items.clear();
                    infoPedido.setText("Información del pedido: " + Session.getPedidoActual().getCodigo());
                    items.addAll(Session.getPedidoActual().getItems());
                }
        );


        columnCantidad.setCellValueFactory((fila) -> {
            String fecha = fila.getValue().getCantidad() + "";
            return new SimpleStringProperty(fecha);
        });

        columnProducto.setCellValueFactory((fila) -> {
            String codigo = fila.getValue().getProducto().getNombre();
            return new SimpleStringProperty(codigo);
        });

        columnPrecioProducto.setCellValueFactory((fila) -> {
            String total = fila.getValue().getProducto().getPrecio();
            return new SimpleStringProperty(total);
        });

    }

    @javafx.fxml.FXML
    public void logout(Event event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmación");
        alert.setHeaderText("¿Estas seguro de que quieres salir?");
        alert.setContentText("Presiona aceptar para cerrar sesión");
        alert.getButtonTypes().setAll(ButtonType.OK, ButtonType.CANCEL);
        alert.showAndWait().ifPresent((response) -> {
            if (response == ButtonType.OK) {
                Session.setUser(null);
                Session.setPedidoActual(null);
                VentaApplication.cambiarSecene("login-view.fxml");
            }
        });
    }
}