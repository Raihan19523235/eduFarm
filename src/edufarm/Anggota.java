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
public class Anggota {
    private SimpleStringProperty nama,nohp,tanggal,jekel,username,password;
    private SimpleIntegerProperty id;

    public Anggota(int id, String nama, String jekel, String nohp, String tanggal, String username,String password) {
        this.id = new SimpleIntegerProperty(id);
        this.nama = new SimpleStringProperty(nama);
        this.jekel = new SimpleStringProperty(jekel);
        this.nohp = new SimpleStringProperty(nohp);
        this.tanggal = new SimpleStringProperty(tanggal);
        this.username = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(password);
    }

    public Anggota() {
        this(0, "", "", "", "", "","");
    }
    
    
    public String getNama() {
        return nama.get();
    }

    public void setNama(String nama) {
        this.nama.set(nama);
    }

    public String getNohp() {
        return nohp.get();
    }

    public void setNohp(String nohp) {
        this.nohp.set(nohp);
    }

    public String getTanggal() {
        return tanggal.get();
    }

    public void setTanggal(String tanggal) {
        this.tanggal.set(tanggal);
    }

    public String getJekel() {
        return jekel.get();
    }

    public void setJekel(String jekel) {
        this.jekel.set(jekel);
    }

    public String getUsername() {
        return username.get();
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getPassword() {
        return password.get();
    }

    public void setPassword(String password) {
        this.password.set(password);
    }
    
    @Override
    public String toString() {
        return "No: " + id +" Nama Lengkap: " + nama + ", No. HP: " + nohp + 
                ", Tanggal: " + tanggal + ", Jenis Kelamin: " + jekel + ", Username: " + username +", Password: " + password;
    }
    
    
}
