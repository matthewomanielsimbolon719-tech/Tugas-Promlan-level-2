package main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;

public class Navigator {
    private static Stage primaryStage;

    public static void setPrimaryStage(Stage stage) {
        primaryStage = stage;
    }

    public static void loadFXML(String fxmlPath) {
        try {
            URL fileUrl = Navigator.class.getResource(fxmlPath);
            if (fileUrl == null) {
                System.err.println("Error: File FXML tidak ditemukan di path: " + fxmlPath);
                return;
            }

            FXMLLoader loader = new FXMLLoader(fileUrl);
            Parent root = loader.load();
            
            if (primaryStage != null) {
                Scene scene = new Scene(root);
                primaryStage.setScene(scene);
                primaryStage.show();
            } else {
                System.err.println("Error: Stage utama belum diinisialisasi!");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Gagal memuat file FXML: " + fxmlPath);
        }
    }
}