module com.cesur.pedidos {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires lombok;

    opens com.cesur.pedidos to javafx.fxml;
    opens properties;
    exports com.cesur.pedidos;
    exports com.cesur.pedidos.controllers;
    opens com.cesur.pedidos.controllers to javafx.fxml;
}