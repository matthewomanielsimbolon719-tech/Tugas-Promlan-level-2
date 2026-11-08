package kelas.controller;
import main.Navigator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import kelas.data.DataProduk;
import kelas.model.Produk;

public class DaftarController {
    @FXML private TextField txtCari;
    @FXML private TableView<Produk> tblProduk;
    @FXML private TableColumn<Produk, String> colKode, colNama, colKategori;
    @FXML private TableColumn<Produk, Double> colHarga;

    @FXML
    public void initialize() {
        colKode.setCellValueFactory(new PropertyValueFactory<>("kode"));
        colNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        colKategori.setCellValueFactory(new PropertyValueFactory<>("kategori"));
        colHarga.setCellValueFactory(new PropertyValueFactory<>("harga"));
        
        tblProduk.setItems(DataProduk.getProdukList());
    }

    @FXML
    void cariData(ActionEvent event) {
        String keyword = txtCari.getText().toLowerCase();
        ObservableList<Produk> hasil = FXCollections.observableArrayList();
        for (Produk p : DataProduk.getProdukList()) {
            if (p.getNama().toLowerCase().contains(keyword)) hasil.add(p);
        }
        tblProduk.setItems(hasil);
    }

    @FXML
    void bukaDetail(ActionEvent event) {
        Produk terpilih = tblProduk.getSelectionModel().getSelectedItem();
        if (terpilih == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Pilih produk terlebih dahulu!");
            alert.showAndWait();
            return;
        }

        try {
            // Memuat halaman detail tanpa Navigator agar bisa mengirim objek data
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/kelas/detail.fxml"));
            Parent root = loader.load();
            
            DetailController controller = loader.getController();
            controller.setProduk(terpilih); // Kirim objek terpilih

            Stage stage = new Stage();
            stage.setTitle("Detail Produk");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    void kembaliKeForm(ActionEvent event) {
        Navigator.loadFXML("/kelas/form.fxml");
    }
}