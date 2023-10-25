package com.cesur.pedidos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class VentaApplication extends Application {
    private static Stage myStage;

    @Override
    public void start(Stage stage) throws IOException {
        myStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(VentaApplication.class.getResource("fxml/login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void loadFXML(String fxml) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(VentaApplication.class.getResource(fxml));
            Scene scene = null;
            scene = new Scene(fxmlLoader.load());
            myStage.setScene(scene);
        } catch (IOException e) {
            System.out.println("Error al cargar el FXML");
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}