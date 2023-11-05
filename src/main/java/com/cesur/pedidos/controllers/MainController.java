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

/**
 * Controlador para la vista principal de la aplicación.
 */
public class MainController implements Initializable {

    @javafx.fxml.FXML
    private TableView<Pedido> table; // Tabla de pedidos.
    @javafx.fxml.FXML
    private TableColumn<Pedido, String> columnCodigo; // Columna para el código de pedido.
    @javafx.fxml.FXML
    private TableColumn<Pedido, String> columnFecha; // Columna para la fecha de pedido.
    @javafx.fxml.FXML
    private TableColumn<Pedido, String> columnPrecio; // Columna para el precio total del pedido.
    @javafx.fxml.FXML
    private Label txtUsuario; // Etiqueta para mostrar el nombre de usuario.
    @javafx.fxml.FXML
    private HBox userMenu; // Contenedor para el menú de usuario.
    @javafx.fxml.FXML
    private ImageView imgSalir; // Imagen para salir de la sesión.
    @javafx.fxml.FXML
    private TableColumn<Item, String> columnProducto; // Columna para el nombre del producto en los ítems.
    @javafx.fxml.FXML
    private TableColumn<Item, String> columnPrecioProducto; // Columna para el precio del producto en los ítems.
    @javafx.fxml.FXML
    private TableColumn<Item, String> columnCantidad; // Columna para la cantidad de productos en los ítems.
    @javafx.fxml.FXML
    private TableView<Item> tableItem; // Tabla de ítems en el pedido.
    @javafx.fxml.FXML
    private Label infoPedido; // Etiqueta para mostrar información del pedido.

    /**
     * Inicializa la vista principal.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Configuración inicial de la vista
        txtUsuario.setText(txtUsuario.getText() + Session.getUser().getNombre());
        ObservableList<Item> items = tableItem.getItems();
        var pedidoDAO = new PedidoDAOImp(DBConnection.getConnection());
        var pedidos = pedidoDAO.loadByUser(Session.getUser().getId());
        table.getItems().addAll(pedidos);

        // Configuración de las columnas de la tabla de pedidos
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
        // Manejo de selección de un pedido en la tabla
        table.getSelectionModel().selectedItemProperty().addListener(
                (observable, vOld, vNew) -> {
                    Session.setPedidoActual(table.getSelectionModel().getSelectedItem());
                    items.clear();
                    infoPedido.setText("Información del pedido: " + Session.getPedidoActual().getCodigo());
                    items.addAll(Session.getPedidoActual().getItems());
                }
        );

        // Configuración de las columnas de la tabla de ítems en el pedido
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

    /**
     * Maneja el evento de cierre de sesión.
     * @param event El evento de clic en la opción de cierre de sesión.
     */
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