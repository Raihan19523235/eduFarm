/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edufarm;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author PREDATOR
 */
public class Hasil {
    private SimpleStringProperty nama,tanggal,bulan;
    private SimpleIntegerProperty hasil;
    
    public Hasil(String nama, int hasil, String bulan , String tanggal) {
        this.nama = new SimpleStringProperty(nama);
        this.hasil = new SimpleIntegerProperty(hasil);
        this.bulan = new SimpleStringProperty(bulan);
        this.tanggal = new SimpleStringProperty(tanggal);
        
    }

    public Hasil() {
        this("", 0, "", "");
    }
    
    public String getNama() {
        return nama.get();
    }

    public void setNama(String nama) {
        this.nama.set(nama);
    }
    
    public int getHasil() {
        return hasil.get();
    }

    public void setHasil(int hasil) {
        this.hasil.set(hasil);
    }
    
    public String getBulan() {
        return bulan.get();
    }

    public void setBulan(String bulan) {
        this.bulan.set(bulan);
    }
    
    public String getTanggal() {
        return tanggal.get();
    }

    public void setTanggal(String tanggal) {
        this.tanggal.set(tanggal);
    }
}

