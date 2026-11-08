package kelas.model;

public class Produk {
    private String kode;
    private String nama;
    private String kategori;
    private double harga;

    public Produk(String kode, String nama, String kategori, double harga) {
        this.kode = kode;
        this.nama = nama;
        this.kategori = kategori;
        this.harga = harga;
    }

    public String getKode() { return kode; }
    public String getNama() { return nama; }
    public String getKategori() { return kategori; }
    public double getHarga() { return harga; }
}