/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edufarm;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author PREDATOR
 */
public class HasilList {
    private ObservableList<Hasil> listData;
    
    public HasilList() {
        listData = FXCollections.observableArrayList();
    }
    
    public ObservableList<Hasil> getListData() {
        return this.listData;
    }
    
    public void setListData(ObservableList<Hasil> listData) {
        this.listData = listData;
    }
    
    public void setData(String nama, int hasil, String tanggal) {
        listData.add(new Hasil(nama, hasil, tanggal));  
    }
}
