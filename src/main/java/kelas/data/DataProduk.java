package kelas.data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import kelas.model.Produk;

public class DataProduk {
    private static DataProduk instance;
    private ObservableList<Produk> daftarProduk;

    private DataProduk() {
        daftarProduk = FXCollections.observableArrayList();
    }

    public static synchronized DataProduk getInstance() {
        if (instance == null) {
            instance = new DataProduk();
        }
        return instance;
    }

    // Method statis agar cocok dengan pemanggilan di DaftarController: DataProduk.getProdukList()
    public static ObservableList<Produk> getProdukList() {
        return getInstance().daftarProduk;
    }

    // Method instance (opsional untuk jaga-jaga)
    public ObservableList<Produk> getDaftarProduk() {
        return daftarProduk;
    }
}