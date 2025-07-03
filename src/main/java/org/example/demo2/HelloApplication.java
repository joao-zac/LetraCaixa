package org.example.demo2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Init.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Home");
        stage.setScene(scene);
        stage.show();
    }

    public class ScreenManager {

        public static void criarTelaModal(String fxmlPath) throws IOException {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource(fxmlPath));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load()));

            stage.initModality(Modality.APPLICATION_MODAL);

            stage.showAndWait();
        }

        public static FXMLLoader criarTelaNaMesmaJanela(Stage currentStage, String fxmlPath) throws IOException {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource(fxmlPath));
            Parent root = loader.load(); // Carrega o root do novo FXML
            Scene scene = new Scene(root); // Cria uma nova Scene
            currentStage.setScene(scene); // Define a nova Scene para o Stage existente
            currentStage.show(); // Garante que o Stage está visível
            return loader; // Retorna o FXMLLoader
        }
    }

    public static void main(String[] args) {
        launch();
    }
}