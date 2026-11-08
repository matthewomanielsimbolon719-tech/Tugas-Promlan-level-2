package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // INI KUNCINYA: Daftarkan stage utama ke Navigator
        Navigator.setPrimaryStage(primaryStage);
        
        // Memuat form pertama kali
        Parent root = FXMLLoader.load(getClass().getResource("/kelas/form.fxml"));

        Scene scene = new Scene(root);
        primaryStage.setTitle("Aplikasi Pencatatan Produk Toko");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}