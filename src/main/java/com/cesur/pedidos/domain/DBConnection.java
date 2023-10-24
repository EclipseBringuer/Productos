package com.cesur.pedidos.domain;

import com.cesur.pedidos.VentaApplication;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
    private static final Connection connection;

    static {
        String url, user, pass;
        var archivo = new Properties();

        try {
            archivo.load(VentaApplication.class.getClassLoader().getResourceAsStream("properties/ddbb.properties"));
            url = "jdbc:mysql://" + archivo.getProperty("host") + ":" + archivo.getProperty("port") +
                    "/" + archivo.getProperty("dbname");
            user = archivo.getProperty("user");
            pass = archivo.getProperty("pass");
        } catch (IOException e) {
            throw new RuntimeException();
        }

        try {
            connection = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
