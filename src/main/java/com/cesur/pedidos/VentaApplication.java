package com.cesur.pedidos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class VentaApplication extends Application {

    private static Stage myStage;

    @Override
    public void start(Stage stage) throws IOException {
        myStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(VentaApplication.class.getResource("fxml/login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 700);
        myStage.setTitle("CholloGaming");
        myStage.setMaximized(true);
        myStage.setScene(scene);
        myStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static void cambiarSecene(String fxml) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(VentaApplication.class.getResource("fxml/" + fxml));
            Pane newPanel = fxmlLoader.load();
            myStage.getScene().setRoot(newPanel);
            myStage.setMaximized(true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}