package kelas.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import kelas.model.Produk;

public class DetailController {
    @FXML private Label lblKode, lblNama, lblKategori, lblHarga;

    // Sesuai syarat tugas: Halaman detail menerima objek produk yang dipilih
    public void setProduk(Produk p) {
        lblKode.setText(p.getKode());
        lblNama.setText(p.getNama());
        lblKategori.setText(p.getKategori());
        lblHarga.setText(String.valueOf(p.getHarga()));
    }
}