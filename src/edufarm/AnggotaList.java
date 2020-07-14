/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edufarm;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.xml.ws.BindingProvider;

/**
 *
 * @author PREDATOR
 */
public class AnggotaList {
    //Raihan Digo Saputra
    //19523235
    private ObservableList<Anggota> listData;
    private int angka, jumLk, jumPr;
    private String nama;
    

    public AnggotaList() {
        listData = FXCollections.observableArrayList();
    }

    public AnggotaList(int angka) {
        this.angka = angka;
    }

    public ObservableList<Anggota> getListData() {
        return this.listData;
    }

    public void setListData(ObservableList<Anggota> listData) {
        this.listData = listData;
    }

    public int getAngka() {
        return angka;
    }

    public void setAngka(int angka) {
        this.angka = angka;
    }
    
    public int getJumPria() {
        return jumLk;
    }

    public void setJumPria(int jumLk) {
        this.jumLk = jumLk;
    }
    public int getJumWanita() {
        return jumPr;
    }

    public void setJumWanita(int jumPr) {
        this.jumPr = jumPr;
    }
    
    public ObservableList<Anggota> getData(){
        return this.listData;
    }
    
    public void setData(int id, String namaLengkap, String jekel, String nohp, String tanggal, String username, String Password) {
        listData.add(new Anggota(id, namaLengkap, jekel, nohp, tanggal, username, Password));  
    }
    
    public void setDummy(){
        listData.add(new Anggota(0, "Raihan", "Pria", "0852123456", "2001-05-11", "Raihan125", "161710203"));
        listData.add(new Anggota(1, "Reyhan", "Pria", "0852654321", "2001-11-05", "Reyhan125","161710203"));  
    }
    
    public void tampil(int jumLk, int jumPr){
        this.jumLk = jumLk;
        this.jumPr = jumPr;
    }
    
    public void Ganti(int angka, String namaLengkap, String jekel, String nohp, String tanggal, String username, String Password){
        listData.set(angka, new Anggota(angka, namaLengkap, jekel, nohp, tanggal, username, Password));   
    }
}
