package com.cesur.pedidos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;
/**
 * Clase principal de la aplicación de ventas.
 */
public class VentaApplication extends Application {

    private static Stage myStage;
    /**
     * Método principal que inicia la aplicación JavaFX.
     * @param stage El escenario principal de la aplicación.
     * @throws IOException Si ocurre un error al cargar el archivo FXML.
     */
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
    /**
     * Método principal de inicio de la aplicación.
     * @param args Los argumentos de la línea de comandos (no se utilizan en este caso).
     */
    public static void main(String[] args) {
        launch();
    }

    /**
     * Cambia la escena actual a otra escena cargada desde un archivo FXML.
     * @param fxml El nombre del archivo FXML a cargar (ubicado en el directorio "fxml").
     */
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