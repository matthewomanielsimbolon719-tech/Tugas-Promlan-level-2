package kelas.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import kelas.data.DataProduk;
import kelas.model.Produk;
import main.Navigator;

import java.net.URL;
import java.util.ResourceBundle;

public class FormController implements Initializable {

    @FXML private TextField txtKode;
    @FXML private TextField txtNama;
    @FXML private ComboBox<String> cbKategori;
    @FXML private TextField txtHarga;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (cbKategori != null) {
            cbKategori.getItems().clear();
            cbKategori.getItems().addAll("Food", "Drink");
        }
    }

    @FXML
    public void simpanProduk() {
        System.out.println("SUKSES: Tombol simpan diklik!");
        
        try {
            String kode = txtKode.getText();
            String nama = txtNama.getText();
            String kategori = cbKategori.getValue();
            
            if (kode == null || kode.trim().isEmpty() || 
                nama == null || nama.trim().isEmpty() || 
                kategori == null) {
                System.err.println("Validasi: Semua field harus diisi!");
                return;
            }

            double harga = Double.parseDouble(txtHarga.getText());

            // Masukkan data ke ObservableList
            Produk produkBaru = new Produk(kode, nama, kategori, harga);
            DataProduk.getProdukList().add(produkBaru);
            
            System.out.println("SUKSES: Data tersimpan, jumlah total: " + DataProduk.getProdukList().size());

            // Berpindah ke halaman daftar produk
            Navigator.loadFXML("/kelas/daftar.fxml");

        } catch (NumberFormatException e) {
            System.err.println("Error: Harga harus berupa angka!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}