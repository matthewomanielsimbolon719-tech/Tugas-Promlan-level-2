package kelas.controller;
import main.Navigator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import kelas.data.DataProduk;
import kelas.model.Produk;

public class FormController {
    @FXML private TextField txtKode, txtNama, txtHarga;
    @FXML private ComboBox<String> cbKategori;

    @FXML
    public void initialize() {
        cbKategori.getItems().addAll("Makanan", "Minuman");
    }

    @FXML
    void simpanProduk(ActionEvent event) {
        try {
            String nama = txtNama.getText();
            double harga = Double.parseDouble(txtHarga.getText());

            // Validasi nama kosong atau harga <= 0
            if (nama.trim().isEmpty() || harga <= 0) {
                showAlert("Error", "Nama produk tidak boleh kosong dan harga harus > 0!");
                return;
            }

            Produk p = new Produk(txtKode.getText(), nama, cbKategori.getValue(), harga);
            DataProduk.tambahProduk(p);
            
            // Pindah ke halaman daftar menggunakan Navigator bawaan praktikum
            Navigator.loadFXML("/kelas/daftar.fxml");

        } catch (NumberFormatException e) {
            showAlert("Error", "Harga harus berupa angka valid!");
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}